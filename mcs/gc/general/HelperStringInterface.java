package mcs.gc.general;

public interface HelperStringInterface {

    /**
     * alloue une nouvelle chaine de char de taille du parametre
     **/
    String generateNew(String value);

    String generateNew(int dep, int size);

    /**
     * concatene 2 chaines de caractere
     **/
    String generateConcat(int dep, int size, String value);

    String generateConcat(String value, int dep, int size);

    String generateConcat(String value1, String value2);

    String generateConcat(int dep1, int size1, int dep2, int size2);

    /**
     * affiche une chaine de car sur stdOut
     **/
    String generateDisplay(String value);

    String generateDisplay(int dep, int size);

    /**
     * lit une chaine de caractere sur stdIn
     **/
    String generateRead();

    /**
     * fonctions de casting
     **/
    String generateStringToBool(String value);

    String generateStringToBool(int dep, int size);

    /**
     * conversion vers l'entier represente par la chaine
     **/
    String generateStringToInt(String value);

    String generateStringToInt(int dep, int size);

    /**
     * extraction du premier caractere de la chaine
     **/
    String generateStringToChar(String value);

    String generateStringToChar(int dep, int size);
}
