package mcs.tds;

import java.util.HashMap;

public class TDS {

    ///   Attributs   ///
    private TDS parent;
    private HashMap<String, VAR> vars;
    private HashMap<String, TYPE> types;

    ///   Constucteurs   ///
    public TDS() { this(null); }
    public TDS(TDS parent) {
        super();
        this.parent = parent;
    }

    ///   Methodes   ///
    /**
     * Recherche une variable dans la TDS et la renvoie.
     * @param id identifiant a rechercher
     * @param local recherche dans la TDS courante
     * @return variable trouvee ou null sinon
     */
    public VAR searchVar(String id) { return searchVar(id, false); }
    public VAR searchVar(String id, boolean local) {
        VAR res = this.vars.get(id);
        if (res == null && !local && parent != null) {
            return this.parent.searchVar(id);
        } else {
            return res;
        }
    }

    /**
     * Ajoute ou mets a jour une variable
     */
    public void putVar(String id, VAR var) { this.vars.put(id, var); }

    /**
     * Recherche un type dans la TDS et la renvoie.
     * @param id identifiant a rechercher
     * @param local recherche dans la TDS courante
     * @return type trouve ou null sinon
     */
    public TYPE searchType(String id) { return searchType(id, false); }
    public TYPE searchType(String id, boolean local) {
        TYPE res = this.types.get(id);
        if (res == null && !local && parent != null) {
            return this.parent.searchType(id);
        } else {
            return res;
        }
    }

    /**
     * Ajoute ou mets a jour un type
     */
    public void putType(String id, TYPE type) { this.types.put(id, type); }
}
