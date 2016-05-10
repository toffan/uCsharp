package mcs.tds;

public class PTR extends TYPE {
 
    ///   Attributs   ///
    private TYPE ptype;

    ///   Constructeurs   ///
    public PTR(TYPE ptype) {
        super(null, 4);
        this.ptype = ptype;
    }
}
