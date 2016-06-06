package mcs.gc.tam;

import mcs.gc.general.*;

/**
 * Implementation des fonctions sur la mémoire de la machine TAM
 *
 * @author antoine
 */
public class TamHelperChar implements HelperCharInterface {

    public String generateDisplay(String value) {
        return "; Affichage d'un char sur stdout.\n"
            + "    LOADL " + value + "\n"
            + "    SUBR COut\n";
    }

    public String generateDisplay(int dep, int size) {
        return "; Affichage d'un char sur stdout.\n"
            + "    LOAD (" + size + ") " + dep + "[LB]\n"
            + "    SUBR COut\n";
    }

    public String generateRead() {
        return "; Lecture char sur stdin.\n"
            + "    SUBR CIn\n";
    }

    public String generateCharToBool(String value) {
        return "; Conversion char vers bool.\n"
            + "    LOADL " + value + "\n"
            + "    SUBR C2B\n";
    }

    public String generateCharToBool(int dep, int size) {
        return "; Conversion char vers bool.\n"
            + "    LOAD (" + size + ") " + dep + "[LB]\n"
            + "    SUBR C2B\n";
    }

    public String generateCharToInt(String value) {
        return "; Conversion char vers int.\n"
            + "    LOADL " + value + "\n"
            + "    SUBR C2I\n";
    }

    public String generateCharToInt(int dep, int size) {
        return "; Conversion char vers int.\n"
            + "    LOAD (" + size + ") " + dep + "[LB]\n"
            + "    SUBR C2I\n";
    }

    public String generateCharToString(String value) {
        return "; Conversion char vers string.\n"
            + "    LOADL " + value + "\n"
            + "    SUBR C2S\n";
    }

    public String generateCharToString(int dep, int size) {
        return "; Conversion char vers string\n"
            + "    LOAD (" + size + ") " + dep + "[LB]\n"
            + "    SUBR C2S\n";
    }
}
