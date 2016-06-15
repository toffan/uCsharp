package mcs.tds;

public class STRUCT extends TYPE {

    ///   Attributs   ///
    protected TDS tds;

    ///   Constructeurs   ///
    public STRUCT() { this(null); }
    public STRUCT(String name) {
        super(name, 0);
        this.tds = new TDS();
    };

    ///   Méthodes   ///
    public VAR searchVar(String id) { return this.tds.searchVar(id, false); }
    public void putVar(String id, TYPE type) {
        this.tds.putVar(id, type);
        this.size += type.size();
    }
}
