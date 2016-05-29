package mcs.gc.general;

public interface HelperIntInterface {

    /** sommer 2 entiers precedemment charges sur la pile. */
    public String generateSum();

    /** soustraire 2 entiers precedemment charges sur la pile.
     * A verifier :
     * (Premier entier) - (dernier entier pousse sur la pile).
     * */
    public String generateSub();

    /** diviser 2 entiers precedemment charges sur la pile.
     * A verifier :
     * (Premier entier) / (dernier entier pousse sur la pile).
     * */
    public String generateDiv();

    /** multiplier 2 entiers precedemment charges sur la pile. */
    public String generateMul();

    /** modulo 2 entiers precedemment charges sur la pile.
     * A verifier :
     * (Premier entier) % (dernier entier pousse sur la pile).
     * */
    public String generateMod();

    /** comparer (egalite) 2 entiers precedemment charges sur la pile.
     * (Premier entier) == (dernier entier pousse sur la pile).
     * */
    public String generateEq();

    /** comparer (inegalite) 2 entiers precedemment charges sur la pile.
     * (Premier entier) != (dernier entier pousse sur la pile).
     * */
    public String generateNeq();

    /** comparer (inferieur strict) 2 entiers precedemment charges sur la pile.
     * A verifier :
     * (Premier entier) < (dernier entier pousse sur la pile).
     * */
    public String generateLss();

    /** comparer (inferieur ou egal) 2 entiers precedemment charges sur la pile.
     * A verifier :
     * (Premier entier) <= (dernier entier pousse sur la pile).
     * */
    public String generateLeq();

    /** comparer (superieur strict) 2 entiers precedemment charges sur la pile.
     * A verifier :
     * (Premier entier) > (dernier entier pousse sur la pile).
     * */
    public String generateGtr();

    /** comparer (superieur ou egal) 2 entiers precedemment charges sur la pile.
     * A verifier :
     * (Premier entier) >= (dernier entier pousse sur la pile).
     * */
    public String generateGeq();

    /** Conversion d'un entier (precedemment charge sur la pile) en booleen. */
    public String generateIntToBool();

    /** afficher un entier sur stdout (valeur) */
    public String generateDisplay(String value);

    /** afficher un entier sur stdout (adresse) */
    public String generateDisplay(int dep, int size);

    /**lire un entier sur stdin */
    public String generateRead();
}
