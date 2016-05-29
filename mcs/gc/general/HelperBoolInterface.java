package mcs.gc.general;

public interface HelperBoolInterface {

    /**
     * Negation d'une valeur booleenne precedemment chargee sur la pile.
     * @return Code de la negation.
     */
    public String generateNegation();

    /**
     * Disjonction de 2 booleens precedemment charges sur la pile.
     * @return Code de la disjonction.
     */
    public String generateOr();

    /** Conjonction de 2 booleens precedemment charges sur la pile.
     * @return Code de la conjonction.
     */
    public String generateAnd();

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
