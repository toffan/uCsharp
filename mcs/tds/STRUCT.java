package mcs.tds;

public class STRUCT extends TYPE {

    ///   Attributs   ///
    private TDS tds;

    ///   Constructeurs   ///
    public STRUCT() { super(null, 0); };

    ///   Méthodes   ///
    public VAR searchVar(String id) {
        return this.tds.searchVar(id, TDS.Scope.LOCAL);
    }
    public void putVar(String id, TYPE type) { this.tds.putVar(id, type); }
}
