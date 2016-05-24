package mcs.gc.general;

public interface HelperBoolInterface {

    /**
     * Negation d'une valeur
     * @param value
     * @return
     */
    public String generateNegation(String value);

    /**
     * Negation d'une valeur
     * @param dep
     * @param taille
     * @return
     */
    public String generateNegation(int dep, int taille);

    /**
     * or de 2 booléens (adresse,valeur)
     * @param dep
     * @param size
     * @param value
     * @return
     */
    public String generateOr(int dep, int size, String value);

    /** or entre 2 valeurs **/
    public String generateOr(String value1, String value2);

    /** or entre 2 adresses **/
    public String generateOr(int dep1, int size1, int dep2, int size2);

    /** and entre 1 adresse une valeur **/
    public String generateAnd(int dep, int size, String value);

    /** and entre 2 valeurs **/
    public String generateAnd(String value1, String value2);

    /** and entre 2 adresses **/
    public String generateAnd(int dep1, int size1, int dep2, int size2);

    /** affiche une valeur bool sur stdout **/
    public String generateDisplay(String value);

    /** affiçche une adresse bool sur stdxout **/
    public String generateDisplay(int dep, int size);

    /** input d'un bool sur stdin **/
    public String generateRead();

    /** bool to char **/
    public String generateBoolToChar();

    /** bool to int **/
    public String generateBoolToInt();

    /** bool to string **/
    public String generateBoolToString();
}
