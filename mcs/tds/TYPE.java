package mcs.tds;

public class TYPE {

    ///   Attributs   ///
    private String name;
    private int size;

    ///   Constructeur   ///
    public TYPE(String name, int size) {
        assert(size > 0);
        this.name = name;
        this.size = size;
    }
}
