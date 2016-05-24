package mcs.gc.tam;

import mcs.gc.general.*;

/**
 * Implementation des fonctions sur les bools de la machine TAM
 * @author antoine
 */
public class TamHelperBool implements HelperBoolInterface {

    public String generateNegation(String value) {
        return "; negation bool"
            + "\tLOADL " + value + "\n"
            + "\tSUBR BNeg";
    }

    public String generateNegation(int dep, int taille) {
        return "; negation bool"
            + "\tLOAD(" + taille + ") " + dep + "[LB] \n"
            + "\tSUBR BNeg";
    }

    public String generateOr(int dep, int size, String value) {
        return "; or (" + dep + "," + size + ") + " + value + "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR BOr\n";
    }


    public String generateOr(String value1, String value2) {
        return "; or " + value1 + " et " + value2 + "\n"
            + "\tLOADL " + value1 + "\n"
            + "\tLOADL " + value2 + "\n"
            + "\tSUBR BOr\n";
    }

    public String generateOr(int dep1, int size1, int dep2, int size2) {
        return "; or (" + dep1 + "," + size1 + ") + (" + dep2 + "," + size2 +
            ") \n"
            + "\tLOAD(" + size1 + ") " + dep1 + "[LB] \n"
            + "\tLOAD(" + size2 + ") " + dep2 + "[LB] \n"
            + "\tSUBR BOr\n";
    }

    public String generateAnd(int dep, int size, String value) {
        return "; and (" + dep + "," + size + ") + " + value + "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR BAnd\n";
    }


    public String generateAnd(String value1, String value2) {
        return "; and " + value1 + " et " + value2 + "\n"
            + "\tLOADL " + value1 + "\n"
            + "\tLOADL " + value2 + "\n"
            + "\tSUBR BAnd\n";
    }

    public String generateAnd(int dep1, int size1, int dep2, int size2) {
        return "; and (" + dep1 + "," + size1 + ") + (" + dep2 + "," + size2 +
            ") \n"
            + "\tLOAD(" + size1 + ") " + dep1 + "[LB] \n"
            + "\tLOAD(" + size2 + ") " + dep2 + "[LB] \n"
            + "\tSUBR BAnd\n";
    }


    public String generateDisplay(String value) {
        return "; display Bool " + value + "\n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR BOut\n";
    }

    public String generateDisplay(int dep, int size) {
        return "; display Bool (" + dep + "," + size + ") \n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR BOut\n";
    }

    public String generateRead() {
        return "; input 1 entier \n"
            + "\tSUBR BIn \n";
    }

    public String generateBoolToChar() {
        return "; bool to char \n"
            + "\tSUBR B2C\n";
    }

    public String generateBoolToInt() {
        return "; bool to int \n"
            + "\tSUBR B2I\n";
    }

    public String generateBoolToString() {
        return "; bool to string \n"
            + "\tSUBR B2S\n";
    }
}