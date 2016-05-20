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
    public boolean isStruct()
    {
        return (this instanceof STRUCT);
    }

    public boolean isPointer()
    {
        return (this instanceof PTR);
    }

    public boolean isFType()
    {
        return (this instanceof FTYPE);
    }

    public STRUCT toStruct()
    {
        return (STRUCT) this;
    }

    public PTR toPointer()
    {
        return (PTR) this;
    }

    public FTYPE toFType()
    {
        return (FTYPE) this;
    }

    ///   Methodes   ///
    public int size() { return this.size; }
    public String name() { return this.name; }
    public void setName(String id) { this.name = id; }
}
