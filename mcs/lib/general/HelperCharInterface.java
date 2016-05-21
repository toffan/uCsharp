package general;

public interface HelperCharInterface {

    /**
     * affiche un char sur std out (valeur)
     **/
    public String generateDisplay(String value);

    /**
     * affiche un char sur stdout (adresse)
     **/
    public String generateDisplay(int dep, int size);

    /**
     * lit un char sur stdin
     **/
    public String generateRead();

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
