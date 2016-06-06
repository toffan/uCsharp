package mcs.tds;

import java.util.ArrayList;


public class FTYPE extends TYPE {

    ///   Attributs   ///
    private TYPE retType;
    private ArrayList<TYPE> params;

    ///   Constructeurs   ///
    public FTYPE(TYPE retType) {
        super(retType.name() + " ()", 1);
        this.retType = retType;
        this.params = new ArrayList<TYPE>();
    }

    ///   Methodes   ///
    public TYPE retType() { return this.retType; }

    public TYPE getParam(int n) { return this.params.get(n); }
    public void putParam(TYPE type) {
        this.params.add(type);
        int end = this.name.length() - 1;
        this.name = this.name.substring(0, end) + type.name() + ", )";
    }
    public int nbParams() { return this.params.size(); }
    public int sizeParams() {
        int res = 0;
        for (TYPE p : params) {
            res += p.size();
        }
        return res;
    }
}
