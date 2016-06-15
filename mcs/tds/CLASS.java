package mcs.tds;

public class CLASS extends STRUCT {

    // Attributs //
    private PTR thisType; // Type de this.

    // Constructeurs //
    public CLASS(TDS parent, String name) {
        super(name);
        PTR localPtr = new PTR(this);
        thisType = parent.searchType(localPtr.name(), true);
        if(thisType == null) {
            parent.putType(localPtr.name(), localPtr);
            thisType = localPtr;
        }
    };

    // Methodes //
    public PTR getThisType() {
        return thisType;
    };

    public void putVar(String id, TYPE type, boolean isPub) {
        this.tds.putVar(id, type, isPub);
        this.size += type.size();
    }

    public void putVar(String id, TYPE type) {
        this.putVar(id, type, true);
    }

    public void putVar(String id, METH meth, boolean isPub) {
        this.tds.putVar(id, meth, isPub);

        // TODO: Gestion du polymorphisme.
    }

    public void putVar(String id, METH meth) {
        this.putVar(id, meth, true);
    }
}
