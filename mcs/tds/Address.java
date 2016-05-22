package mcs.tds;

/**
 * Decrit une adresse memoire (deplacement)
 */
public class Address {

    ///   Attributs   ///
    private int val;

    ///   Constructeurs   ///
    public Address() { this.val = 0; }
    private Address(int val) { this.val = val; }

    ///   Methodes   ///
    public Address next(int dplt) { return new Address(this.val + dplt); }
    public int val() { return this.val; }
}
