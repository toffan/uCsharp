package mcs.tds;

import java.util.HashMap;

public class TDS {

    ///   Types   ///
    public enum Scope { LOCAL, GLOBAL }

    ///   Attributs   ///
    private Address nxtAddr;
    private TDS parent;
    private HashMap<String, VAR> vars;
    private HashMap<String, TYPE> types;

    ///   Constucteurs   ///
    public TDS() { this(null); }
    public TDS(TDS parent) {
        this.nxtAddr = parent == null ? new Address() : parent.nxtAddr;
        this.parent = parent;
        this.vars = new HashMap<String, VAR>();
        this.types = new HashMap<String, TYPE>();
    }

    ///   Methodes   ///
    /**
     * Recherche une variable dans la TDS et la renvoie.
     * @param id identifiant a rechercher
     * @param scope portee de la recherche
     * @return variable trouvee ou null sinon
     */
    public VAR searchVar(String id, Scope scope) {
        VAR res = this.vars.get(id);
        if (res == null && scope == Scope.GLOBAL && parent != null) {
            return this.parent.searchVar(id, Scope.GLOBAL);
        } else {
            return res;
        }
    }

    /**
     * Ajoute ou mets a jour une variable
     */
    public void putVar(String id, TYPE type) {
        VAR var = new VAR(type, this.nxtAddr);
        this.nxtAddr = this.nxtAddr.next(type.size());
        this.vars.put(id, var);
    }

    /**
     * Recherche un type dans la TDS et la renvoie.
     * @param id identifiant a rechercher
     * @param scope portee de la recherche
     * @return type trouve ou null sinon
     */
    public TYPE searchType(String id, Scope scope) {
        TYPE res = this.types.get(id);
        if (res == null && scope == Scope.GLOBAL && parent != null) {
            return this.parent.searchType(id, Scope.GLOBAL);
        } else {
            return res;
        }
    }

    /**
     * Ajoute ou mets a jour un type
     */
    public void putType(String id, TYPE type) { this.types.put(id, type); }
}
