package mcs.gc.tam;

import mcs.gc.general.*;

/**
 * Implementation des fonctions sur les bools de la machine TAM
 * @author antoine
 */
public class TamHelperBool implements HelperBoolInterface {

    public String generateNegation() {
        return "; negation bool\n"
            + "\tSUBR BNeg";
    }

    public String generateOr() {
        return "; disjonction de deux booleens precedemment charges sur la pile.\n"
            + "\tSUBR BOr\n";
    }

    public String generateAnd() {
        return "; conjonction de deux booleens precedemment charges sur la pile.\n"
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
