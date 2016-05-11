package mcs.tds;

public class TYPE {

    ///   Attributs   ///
    protected String name;
    protected int size;

    ///   Constructeurs   ///
    public TYPE(String name, int size) {
        assert(size >= 0); // Une struct peut initialement être vide
        this.name = name;
        this.size = size;
    }

    ///   Methodes   ///
    public int size() { return this.size; }
}
