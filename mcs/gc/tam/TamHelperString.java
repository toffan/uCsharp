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
        // TODO: Tester le bon fonctionnement de SAlloc et de tam en general...
        return "; allocation d'une nouvelle string de taille " +
            value.length() + " \n"
            + "    LOADL " + value.length() + "\n"
            + "    SUBR SAlloc\n"
            + "; affectation de la chaine.\n"
            + "    LOADL " + value + "\n"
            + "; duplication de l'adresse de la chaine.\n"
            + "    LOAD (1) -" + new Integer(value.length() + 1) + "[ST]\n"
            + "    STOREI (" + value.length() + ")\n";
    }

    public String generateNew(int dep, int size) {
        return "; allocation d'une nouvelle string de taille (" + dep + "," +
            size + ") \n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR SAlloc\n";
    }

    @Override
    public String generateConcat(int dep, int size, String value) {
        return "; concatenation de (" + dep + "," + size + ") - " + value + "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR SConcat\n";
    }

    @Override
    public String generateConcat(String value, int dep, int size) {
        return "; concatenation de " + value + " - (" + dep + "," + size +
            ") \n"
            + "\tLOADL " + value + "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR SConcat\n";
    }

    @Override
    public String generateConcat(String value1, String value2) {
        return "; concatenation de " + value1 + " + " + value2 + "\n"
            + "\tLOADL " + value1 + "\n"
            + "\tLOADL " + value2 + "\n"
            + "\tSUBR SConcat\n";
    }

    @Override
    public String generateConcat(int dep1, int size1, int dep2, int size2) {
        return "; concatenation de  (" + dep1 + "," + size1 + ") + (" + dep2 +
            "," + size2 + ")\n"
            + "\tLOAD(" + size1 + ") " + dep1 + "[LB] \n"
            + "\tLOAD(" + size2 + ") " + dep2 + "[LB] \n"
            + "\tSUBR SConcat\n";
    }

    public String generateDisplay(String value) {
        return "; affichage d'une string sur stdout \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR SOut\n";
    }

    public String generateDisplay(int dep, int size) {
        return "; affichage d'une string sur stdout \n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR SOut\n";
    }

    public String generateRead() {
        return "; input string \n"
            + "\tSUBR BIn \n";
    }

    public String generateStringToBool(String value) {
        return "; conversion string to bool\n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR S2B\n";
    }

    public String generateStringToBool(int dep, int size) {
        return "; conversion string to bool\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR S2B\n";
    }

    public String generateStringToInt(String value) {
        return "; conversion string to int \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR S2I\n";
    }

    public String generateStringToInt(int dep, int size) {
        return "; conversion string to int \n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR S2I\n";
    }

    public String generateStringToChar(String value) {
        return "; extraction premier char de la string \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR S2C\n";
    }

    public String generateStringToChar(int dep, int size) {
        return "; extraction premier char de la string \n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR S2C\n";
    }
}
