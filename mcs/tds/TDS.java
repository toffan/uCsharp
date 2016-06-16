package mcs.tds;

import java.util.ArrayList;
import java.util.HashMap;

public class TDS {

    ///   Attributs   ///
    private Address nxtAddr;
    private TDS parent;
    private HashMap<String, VAR> vars;
    private HashMap<String, TYPE> types;
    private HashMap<String, TDS> nsInside;
    private ArrayList<TDS> nsUsed;

    private boolean fct;

    public Logger lg;

    ///   Constucteurs   ///
    public TDS() { this(null, false); }
    /**
     * Constructeur de TDS.
     * @param parent TDS parente
     * @param fct indique si la TDS créée fait partie d'une fonction.
     */
    public TDS(TDS parent, boolean fct) {
        this.nxtAddr = (parent == null || fct) ? new Address(fct ? "LB" : "SB")
                                               : parent.nxtAddr;
        this.parent = parent;
        this.nsUsed = new ArrayList<TDS>();
        this.vars = new HashMap<String, VAR>();
        this.types = new HashMap<String, TYPE>();
        this.nsInside = new HashMap<String, TDS>();
        this.fct = fct;

        this.lg = new Logger(true);
    }

    ///   Methodes   ///
    /**
     * Recupere un namespace, le cree ssi besoin et ssi create est a true.
     * @param id identifiant a creer
     * @param create Est-ce que je cree un ns en cas d'echec ?
     * @return tds table des symboles
     */
    public TDS getNamespace(String id, boolean create) {
        this.lg.entry("NS: Recuperation de la TDS de " + id);

        TDS res = this.nsInside.get(id);

        // Dans une recherche montante avec succes, je renvoie mon resultat.
        if(res != null && !create)
            return res;

        // Sinon, je cherche dans mon parent.
        if (res == null) {
            if(parent != null) {
                res = this.parent.getNamespace(id, false);
            }

            // Si je suis dans une recherche montante, je renvoie mon resultat.
            if(!create) {
                return res;
            }

            if(res == null) {
                // Sinon, je cree le namespace.
                res = new TDS(this, false);
                this.nsInside.put(id,res);
            }
        }
        return res;
    }

    /**
     * Ajoute un namespace dans les namespace utilises.
     * @param tds tds associee au namespace
     */
    // La recherche du ns est a faire separement avec un getNamespace( , false)
    public void use(TDS tds) {
        this.lg.entry("NS: Ajout d'un using...");
        if(tds != null) {
            this.nsUsed.add(tds);
        }
    }


    /**
     * Recherche une variable dans la TDS et la renvoie.
     * @param id identifiant a rechercher
     * @param go_global portee de la recherche, est-ce qu'elle est globale ?
     * @return variable trouvee ou null sinon
     */
    public VAR searchVar(String id, boolean go_global) {
        this.lg.entry("recherche de la VAR '" + id + "'.");

        VAR res = this.vars.get(id);
        if (res == null && go_global && parent != null) {
            res = this.parent.searchVar(id, go_global);
        }

        // La recherche dans les ns utilises est moins prioritaire sur tout.
        if (res == null) {
            for (TDS nsTds : this.nsUsed)
            {
                VAR local = nsTds.searchVar(id, false);

                // Resolution ambigue
                if (res != null && local != null && res != local) {
                    throw new RuntimeException("Symbole " + id + " ambigu.");
                }

                // Resolution succes
                if (res == null) {
                    res = local;
                }
            }
        }
        return res;
    }

    /**
     * Ajoute ou mets a jour une variable
     */
    public void putVar(String id, TYPE type, boolean isPub) {
        this.lg.entry("ajout de la VAR '" + id + "' de TYPE '" + type.name() +
                      "'.");

        VAR var = new VAR(type, this.nxtAddr);
        var.setPub(isPub);

        this.nxtAddr = this.nxtAddr.next(type.size());
        this.vars.put(id, var);
    }

    public void putVar(String id, TYPE type) {
        this.putVar(id, type, true);
    }

    /**
     * Ajoute ou mets a jour une fonction
     */
    public void putVar(String id, FCT fct, boolean isPub) {
        this.lg.entry("ajout de la FCT '" + id + "'.");

        fct.setPub(isPub);
        this.vars.put(id, fct);
    }

    public void putVar(String id, FCT fct) {
        this.putVar(id, fct, true);
    }

    /**
     * Termine l'ajout des paramètres d'une fonction.
     * Transforme l'adresse des paramètres en adresses négatives.
     * Ajoute trois variables réservées correspondant aux trois cases mémoires
     * créées lors d'un appel de fonction.
     */
    public void endFunctionDeclaration() {
        if (this.fct) {
            // Désactive les usages futurs de cette fonction.
            this.fct = false;
            // Calcul du décalage à appliquer aux adresses des paramètres.
            int offset = -(this.nxtAddr.val());
            for (VAR v : this.vars.values()) {
                v.addr().shift(offset);
            }
            // Réinitialisation de l'adresse courante.
            this.nxtAddr.shift(offset);
            // Ajout des variables réservées.
            this.putVar("@1", this.searchType("int", true));
            this.putVar("@2", this.searchType("int", true));
            this.putVar("@3", this.searchType("int", true));
        }
    }

    /**
     * Recherche un type dans la TDS et la renvoie.
     * @param id identifiant a rechercher
     * @param go_global portee de la recherche, est-ce qu'elle est globale ?
     * @return type trouve ou null sinon
     */
    public TYPE searchType(String id, boolean go_global) {
        this.lg.entry("recherche du TYPE '" + id + "'.");

        TYPE res = this.types.get(id);
        if (res == null && go_global && parent != null) {
            res = this.parent.searchType(id, go_global);
        }

        // La recherche dans les ns utilises est moins prioritaire sur tout.
        if (res == null) {
            for (TDS nsTds : this.nsUsed)
            {
                TYPE local = nsTds.searchType(id, false);

                // Resolution ambigue
                if (res != null && local != null && res != local) {
                    throw new RuntimeException("Symbole " + id + " ambigu.");
                }

                // Resolution succes
                if (res == null) {
                    res = local;
                }
            }
        }
        return res;
    }

    /**
     * Ajoute ou mets a jour un type
     */
    public void putType(String id, TYPE type, boolean isPub) {
        // Si le type est anonyme (struct par exemple), on le nomme d'apres son
        // id.
        if (type.name().isEmpty()) {
            type.setName(id);
        }
        type.setPub(isPub);
        this.lg.entry("ajout du TYPE '" + type.name() + "' de taille " +
                      type.size() + " en tant que '" + id + "'.");
        this.types.put(id, type);
    }

    public void putType(String id, TYPE type) {
        putType(id, type, true);
    }
}
