package general;

public interface HelperCharInterface {

    /**
     * affiche un char sur std out (valeur)
     **/
    public String generateDisplayChar(String value);

    /**
     * affiche un char sur stdout (adresse)
     **/
    public String generateDisplayChar(int dep, int size);

    /**
     * lit un char sur stdin
     **/
    public String generateReadChar();

    /**
     * char to bool convesion (valeur)
     **/
    public String generateCharToBool(String value);

    public String generateCharToBool(int dep, int size);

    public String generateCharToInt(String value);

    public String generateCharToInt(int dep, int size);

    public String generateCharToString(String value);

    public String generateCharToString(int dep, int size);
}
