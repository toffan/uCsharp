package mcs.gc;

/**
 * Decrit une adresse memoire (registre + deplacement)
 */
public class Address {

    ///   Attributs   ///
    private Register reg;
    private int dplt;

    ///   Constructeurs   ///
    public Address(Register reg, int dplt) {
        this.dplt = dplt;
        this.reg = reg;
    }
}
