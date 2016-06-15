package mcs.tds;

import java.util.ArrayList;


public class METH extends FCT {

    ///   Constructeurs   ///
    public METH(CLASS classType, FTYPE type, TDS parente, String name) {
        super(type, parente, name);
        type.putParam(classType.getThisType());
        this.putParam("this");
    }

}
