package mcs.tds;

import java.util.HashMap;

public class TDS {

    ///   Attributs   ///
    private Address nxtAddr;
    private TDS parent;
    private HashMap<String, VAR> vars;
    private HashMap<String, TYPE> types;

    public Logger lg;

    ///   Constucteurs   ///
    public TDS() { this(null); }
    public TDS(TDS parent) {
        this.nxtAddr = parent == null ? new Address() : parent.nxtAddr;
        this.parent = parent;
        this.vars = new HashMap<String, VAR>();
        this.types = new HashMap<String, TYPE>();

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
}
