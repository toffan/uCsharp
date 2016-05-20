package mcs.tds;

import java.util.ArrayList;


public class FCT extends VAR {

    ///   Attributs   ///
    private ArrayList<String> params;
    private TDS tds;

    ///   Constructeurs   ///
    public FCT(FTYPE type, TDS parente) {
        super(type);
        this.params = new ArrayList<String>();
        this.tds = new TDS(parente);
    }

    ///   Methodes   ///
    public void putParam(String id) { this.params.add(id); }
    public String getParam(int i) { return this.params.get(i); }
    public boolean contains(String id) {
        boolean res = false;
        for (p : params) {
            res = id.equals(p);
            if(res) break;
        }
        return res;
    }

    public TDS tds() { return this.tds; }
    public FTYPE type() {
        // Si le cast echoue, c'est du a une erreur de conception.
        return (FTYPE) this.type;
    }
}

