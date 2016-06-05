package mcs.gc.tam;

import mcs.gc.general.*;

/**
 * Implementation des fonctions sur la mémoire de la machine TAM
 *
 * @author antoine
 */
public class TamHelperString implements HelperStringInterface {

    @Override
    public String generateNew(String value) {
        int realLength = value.length()-2; // la longueur de la chaine "hello" est de nombre de caractere total -2;
        return "; Allocation d'une nouvelle string de taille " +
        realLength + "\n"
            + "    LOADL " + realLength + "\n"
            + "    SUBR SAlloc\n"
            + "; affectation de la chaine.\n"
            + "    LOADL " + value + "\n"
            + "; duplication de l'adresse de la chaine.\n"
            + "    LOAD (1) -" + new Integer(realLength + 1) + "[ST]\n"
            + "    STOREI (" + realLength + ")\n";
    }

    public String generateNew(int dep, int size) {
        return "; Allocation d'une nouvelle string de taille (" + dep + "," +
            size + ")\n"
            + "    LOAD(" + size + ") " + dep + "[LB]\n"
            + "    SUBR SAlloc\n";
    }

    @Override
    public String generateConcat(int dep, int size, String value) {
        return "; Concatenation de (" + dep + "," + size + ") - " + value + "\n"
            + "    LOAD(" + size + ") " + dep + "[LB]\n"
            + "    LOADL " + value + "\n"
            + "    SUBR SConcat\n";
    }

    @Override
    public String generateConcat(String value, int dep, int size) {
        return "; Concatenation de " + value + " - (" + dep + "," + size + ")\n"
            + "    LOADL " + value + "\n"
            + "    LOAD(" + size + ") " + dep + "[LB]\n"
            + "    SUBR SConcat\n";
    }

    @Override
    public String generateConcat(String value1, String value2) {
        return "; Concatenation de " + value1 + " + " + value2 + "\n"
            + "    LOADL " + value1 + "\n"
            + "    LOADL " + value2 + "\n"
            + "    SUBR SConcat\n";
    }

    @Override
    public String generateConcat(int dep1, int size1, int dep2, int size2) {
        return "; Concatenation de  (" + dep1 + "," + size1 + ") + (" + dep2 +
            "," + size2 + ")\n"
            + "    LOAD(" + size1 + ") " + dep1 + "[LB]\n"
            + "    LOAD(" + size2 + ") " + dep2 + "[LB]\n"
            + "    SUBR SConcat\n";
    }

    public String generateDisplay(String value) {
        return "; Affichage d'une string sur stdout.\n"
            + "    LOADL " + value + "\n"
            + "    SUBR SOut\n";
    }

    public String generateDisplay(int dep, int size) {
        return "; Affichage d'une string sur stdout.\n"
            + "    LOAD(" + size + ") " + dep + "[LB]\n"
            + "    SUBR SOut\n";
    }

    public String generateRead() {
        return "; Input string.\n"
            + "    SUBR BIn\n";
    }

    public String generateStringToBool(String value) {
        return "; Conversion string vers bool.\n"
            + "    LOADL " + value + "\n"
            + "    SUBR S2B\n";
    }

    public String generateStringToBool(int dep, int size) {
        return "; Conversion string vers bool.\n"
            + "    LOAD(" + size + ") " + dep + "[LB]\n"
            + "    SUBR S2B\n";
    }

    public String generateStringToInt(String value) {
        return "; Conversion string vers int.\n"
            + "    LOADL " + value + "\n"
            + "    SUBR S2I\n";
    }

    public String generateStringToInt(int dep, int size) {
        return "; Conversion string vers int.\n"
            + "    LOAD(" + size + ") " + dep + "[LB]\n"
            + "    SUBR S2I\n";
    }

    public String generateStringToChar(String value) {
        return "; Extraction premier char de la string.\n"
            + "    LOADL " + value + "\n"
            + "    SUBR S2C\n";
    }

    public String generateStringToChar(int dep, int size) {
        return "; Extraction premier char de la string.\n"
            + "    LOAD(" + size + ") " + dep + "[LB]\n"
            + "    SUBR S2C\n";
    }
}
