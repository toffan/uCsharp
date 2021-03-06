package mcs.tds;

import java.util.HashMap;

public class TDS {

    ///   Attributs   ///
    private Address nxtAddr;
    /** Adresse de reference / de base pour les fonctions.
     * Permet de calculer l'adresse absolue des variables locales aux fonctions.
     */
    private Address refAddr;
    private TDS parent;
    private HashMap<String, VAR> vars;
    private HashMap<String, TYPE> types;
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
        this.refAddr = fct ? parent.nxtAddr : null;
        this.parent = parent;
        this.vars = new HashMap<String, VAR>();
        this.types = new HashMap<String, TYPE>();
        this.fct = fct;

        this.lg = new Logger(true);
    }

    ///   Methodes   ///
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
            return this.parent.searchVar(id, go_global);
        } else {
            return res;
        }
    }

    /**
     * Ajoute ou mets a jour une variable
     */
    public void putVar(String id, TYPE type) {
        this.lg.entry("ajout de la VAR '" + id + "' de TYPE '" + type.name() +
                      "'.");

        VAR var = new VAR(type, this.nxtAddr);
        this.nxtAddr = this.nxtAddr.next(type.size());
        this.vars.put(id, var);
    }

    /**
     * Ajoute ou mets a jour une fonction
     */
    public void putVar(String id, FCT fct) {
        this.lg.entry("ajout de la FCT '" + id + "'.");

        this.vars.put(id, fct);
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
     * Retourne l'adresse de base (valeur) de la fonction
     * (adresse courante de la TDS au moment de la creation de la fonction.).
     * */
    public int refAddr() {
        return (this.refAddr == null) ? 0 : this.refAddr.val();
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
            return this.parent.searchType(id, go_global);
        } else {
            return res;
        }
    }

    /**
     * Ajoute ou mets a jour un type
     */
    public void putType(String id, TYPE type) {
        // Si le type est anonyme (struct par exemple), on le nomme d'apres son
        // id.
        if (type.name().isEmpty()) {
            type.setName(id);
        }
        this.lg.entry("ajout du TYPE '" + type.name() + "' de taille " +
                      type.size() + " en tant que '" + id + "'.");
        this.types.put(id, type);
    }

    /**
     * Renvoie la taille de l'ensemble des variables de la TDS
     */
    public int typeSize() {
        int size = 0;
        for (VAR v: this.vars.values()) {
            size += v.type().size();
        }
        return size;
    }
}
