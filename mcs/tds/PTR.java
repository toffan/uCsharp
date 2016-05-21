package mcs.tds;

public class PTR extends TYPE {

    ///   Attributs   ///
    private TYPE ptype;

    ///   Constructeurs   ///
    public PTR(TYPE ptype) {
        super(ptype.name() + "*", 1);
        this.ptype = ptype;
    }

    ///   Methodes   ///
    public TYPE ptype() { return this.ptype; }
}
