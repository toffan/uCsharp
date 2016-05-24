package mcs.gc.tam;

import mcs.gc.general.*;

/**
 * Implementation des fonctions sur la mémoire de la machine TAM
 *
 * @author antoine
 */
public class TamHelperChar implements HelperCharInterface {

    public String generateDisplay(String value) {
        return "; affichage d'un char sur stdout \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR COut\n";
    }

    public String generateDisplay(int dep, int size) {
        return "; affichage d'un char sur stdout \n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR COut\n";
    }

    public String generateRead() {
        return "; lecture char sur stdin\n"
            + "\tSUBR CIn\n";
    }

    public String generateCharToBool(String value) {
        return "; conversion char to bool\n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR C2B\n";
    }

    public String generateCharToBool(int dep, int size) {
        return "; conversion char to bool\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR C2B\n";
    }

    public String generateCharToInt(String value) {
        return "; conversion char to int \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR C2I\n";
    }

    public String generateCharToInt(int dep, int size) {
        return "; conversion char to int \n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR C2I\n";
    }

    public String generateCharToString(String value) {
        return "; conversion char to string \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR C2S\n";
    }

    public String generateCharToString(int dep, int size) {
        return "; conversion char to string \n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR C2S\n";
    }
}