package mcs.tds;

import mcs.gc.Address;

public class VAR {

    ///   Attributs   ///
    private TYPE type;
    private Address addr;

    ///   Constructeurs   ///
    public VAR(TYPE type, Address addr) {
        this.type = type;
        this.addr = addr;
    }
}