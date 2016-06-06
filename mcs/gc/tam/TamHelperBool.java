package mcs.gc.tam;

import mcs.gc.general.*;

/**
 * Implementation des fonctions sur les bools de la machine TAM
 * @author antoine
 */
public class TamHelperBool implements HelperBoolInterface {

    public String generateNegation() {
        return "; Negation booleen.\n"
            + "    SUBR BNeg";
    }

    public String generateOr() {
        return "; Disjonction de deux booleens (precedemment charges sur la pile).\n"
            + "    SUBR BOr\n";
    }

    public String generateAnd() {
        return "; Conjonction de deux booleens (precedemment charges sur la pile).\n"
            + "    SUBR BAnd\n";
    }

    public String generateDisplay(String value) {
        return "; Affichage booleen : " + value + "\n"
            + "    LOADL " + value + "\n"
            + "    SUBR BOut\n";
    }

    public String generateDisplay(int dep, int size) {
        return "; Affichage booleen (" + dep + "," + size + ")\n"
            + "    LOAD (" + size + ") " + dep + "[LB]\n"
            + "    SUBR BOut\n";
    }

    public String generateRead() {
        return "; Input entier.\n"
            + "    SUBR BIn\n";
    }

    public String generateBoolToChar() {
        return "; Conversion bool vers char.\n"
            + "    SUBR B2C\n";
    }

    public String generateBoolToInt() {
        return "; Conversion bool vers int.\n"
            + "    SUBR B2I\n";
    }

    public String generateBoolToString() {
        return "; Conversion bool vers string.\n"
            + "    SUBR B2S\n";
    }
}
