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

    /**
     * Renvoie l'adresse suivante.
     * @param dplt taille de la variable mémorisée.
     */
    public Address next(int dplt) {
        return new Address(this.ref, this.val + dplt);
    }

    /**
     * Effectue une translation de offset de l'adresse.
     * @param offset valeur du déplacement à effectuer.
     */
    public void shift(int offset) { this.val += offset; }

    /**
     * Retourne la valeur de l'adresse courante.
     */
    public int val() { return this.val; }

    /**
     * Retourne le nom/reference de la TDS (reference de l'adresse).
     */
    public String ref() { return this.ref; }
}
