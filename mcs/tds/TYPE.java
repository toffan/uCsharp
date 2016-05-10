package mcs.tds;

public class TYPE {

    ///   Attributs   ///
    private String name;
    private int size;

    ///   Constructeurs   ///
    public TYPE(String name, int size) {
        assert(size > 0);
        this.name = name;
        this.size = size;
    }
}
