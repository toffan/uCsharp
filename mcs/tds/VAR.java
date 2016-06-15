package mcs.tds;

public class VAR {

    ///   Attributs   ///
    private TYPE type;
    private Address addr;
    private boolean pub;//le debut public sans les voyelles. vaut true si la variable est publique

    ///   Constructeurs   ///
    public VAR(TYPE type, Address addr) {
        this.type = type;
        this.addr = addr;
    }

    public VAR(TYPE type) { this.type = type; }

    ///   Methodes   ///
    public TYPE type() { return this.type; }
    public Address addr() { return this.addr; }
    public void setAddr(Address addr) { this.addr = addr; }
    
    public boolean pub(){return this.pub; }
    public void setPub(boolean pub){ this.pub = pub; }
}
