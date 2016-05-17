package mcs.tds;

import java.util.ArrayList;


public class FCT extends VAR {

    ///   Attributs   ///
    private ArrayList<String> params;
    private TDS tds;

    ///   Constructeurs   ///
    public FCT(FTYPE type) {
        super(type, new Address()); // TODO manage the Address
        this.params = new ArrayList<String>();
        this.tds = new TDS();
    }
}
