package mcs.tds;

/**
 * Decrit une adresse memoire (deplacement)
 */
public class Address {

    ///   Attributs   ///
    private int val;
    /** Permet de transmettre le nom de la TDS aux variables memorisees. */
    private String ref;

    ///   Constructeurs   ///
    public Address(String ref) {
        this.val = 0;
        this.ref = ref;
    }
    private Address(String ref, int val) {
        this.val = val;
        this.ref = ref;
    }

    ///   Methodes   ///
    public Address next(int dplt) {
        return new Address(this.ref, this.val + dplt);
    }
    public Address updateRef(String ref) {
        this.ref = ref;
        return this;
    }
    public int val() { return this.val; }
    /** Retourne le nom/reference de la TDS (reference de l'adresse). */
    public String ref() { return this.ref; }
}
