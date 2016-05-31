package mcs.gc.tam;

import mcs.gc.general.*;

/**
 * Implementation des fonctions sur les entiers de la machine TAM
 *
 * @author antoine
 */
public class TamHelperInt implements HelperIntInterface {

    @Override
    public String generateNeg() {
        return "; Negation entiere (entier precedemment empile).\n"
            + "    SUBR INeg\n";
    }

    @Override
    public String generateSum() {
        return "; Somme de deux entiers (precedemment empiles).\n"
            + "    SUBR IAdd\n";
    }

    @Override
    public String generateSub() {
        return "; Soustraction de deux entiers (precedemment empiles).\n"
            + "    SUBR ISub\n";
    }

    @Override
    public String generateDiv() {
        return "; Division de deux entiers (precedemment empiles) (le dernier entier charge etant le denominateur).\n"
            + "    SUBR IDiv\n";
    }

    @Override
    public String generateMul() {
        return "; Multiplication de deux entiers (precedemment empiles).\n"
            + "    SUBR IMul\n";
    }

    @Override
    public String generateMod() {
        return "; Modulo de deux entiers (precedemment empiles).\n"
            + "    SUBR IMod\n";
    }

    @Override
    public String generateEq() {
        return "; Comparaison (egalite) de deux entiers (precedemment empiles).\n"
            + "    SUBR IEq\n";
    }

    @Override
    public String generateNeq() {
        return "; Comparaison (inegalite) de deux entiers (precedemment empiles).\n"
            + "    SUBR INeq\n";
    }

    @Override
    public String generateLss() {
        return "; Comparaison (inferieur strict) de deux entiers (precedemment empiles).\n"
            + "    SUBR ILss\n";
    }

    @Override
    public String generateLeq() {
        return "; Comparaison (inferieur ou egal) de deux entiers (precedemment empiles).\n"
            + "    SUBR ILeq\n";
    }

    @Override
    public String generateGtr() {
        return "; Comparaison (superieur strict) de deux entiers (precedemment empiles).\n"
            + "    SUBR IGtr\n";
    }

    @Override
    public String generateGeq() {
        return "; Comparaison (superieur ou egal) de deux entiers (precedemment empiles).\n"
            + "    SUBR IGeq\n";
    }

    @Override
    public String generateIntToBool() {
        return "; Conversion d'un entier (precedemment empile) en booleen.\n"
            + "    SUBR I2B\n";
    }

    @Override
    public String generateDisplay(String value) {
        return "; Affichage d'un entier sur stdout.\n"
            + "    LOADL " + value + "\n"
            + "    SUBR IOut\n";
    }

    @Override
    public String generateDisplay(int dep, int size) {
        return "; Affichage d'un entier sur stdout.\n"
            + "    LOAD(" + size + ") " + dep + "[LB]\n"
            + "    SUBR IOut\n";
    }

    @Override
    public String generateRead() {
        return "; Lecture d'un entier sur stdin.\n"
            + "SUBR IIn\n";
    }
}
