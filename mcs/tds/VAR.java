package mcs.tds;

public class VAR {

    ///   Attributs   ///
    private TYPE type;
    private Address addr;

    ///   Constructeurs   ///
    public VAR(TYPE type, Address addr) {
        this.type = type;
        this.addr = addr;
    }

    ///   Methodes   ///
    public TYPE type() { return this.type; }
    public Address addr() { return this.addr; }
}
