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

    ///   Proxy InstanceOf   ///
    boolean isStruct()
    {
        return (this instanceof STRUCT);
    }

    boolean isPointer()
    {
        return (this instanceof PTR);
    }

    boolean isFType()
    {
        return (this instanceof FTYPE);
    }

    STRUCT toStruct()
    {
        return (STRUCT) this;
    }

    PTR toPointer()
    {
        return (PTR) this;
    }

    FTYPE toFType()
    {
        return (FTYPE) this;
    }

    ///   Methodes   ///
    public int size() { return this.size; }
    public String name() { return this.name; }
}
