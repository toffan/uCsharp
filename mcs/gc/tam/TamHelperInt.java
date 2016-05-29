package mcs.gc.tam;

import mcs.gc.general.*;

/**
 * Implementation des fonctions sur les entiers de la machine TAM
 *
 * @author antoine
 */
public class TamHelperInt implements HelperIntInterface {

    @Override
    public String generateSum() {
        return "; somme des deux entiers charges precedemment.\n"
            + "\tSUBR IAdd\n";
    }

    @Override
    public String generateSub() {
        return "; soustraction des deux entiers charges precedemment (le dernier entier charge etant celui a soustraire).\n"
            + "\tSUBR ISub\n";
    }

    @Override
    public String generateDiv() {
        return "; division de deux entiers charges precedemment (le dernier entier charge etant le denominateur).\n"
            + "\tSUBR IDiv\n";
    }

    @Override
    public String generateMul() {
        return "; multiplication de deux entiers charges precedemment.\n"
            + "\tSUBR IMul";
    }

    @Override
    public String generateMod() {
        return "; modulo de deux entiers charges precedemment.\n"
            + "\tSUBR IMod\n";
    }

    @Override
    public String generateEq() {
        return "; comparaison (egalite) entre deux entiers charges precedemment.\n"
            + "\tSUBR IEq\n";
    }

    @Override
    public String generateNeq() {
        return "; comparaison (inegalite) entre deux entiers charges precedemment.\n"
            + "\tSUBR INeq\n";
    }

    @Override
    public String generateLss() {
        return "; comparaison (inferieur strict) entre deux entiers charges precedemment.\n"
            + "\tSUBR ILss\n";
    }

    @Override
    public String generateLeq() {
        return "; comparaison (inferieur ou egal) entre deux entiers charges precedemment.\n"
            + "\tSUBR ILeq\n";
    }

    @Override
    public String generateGtr() {
        return "; comparaison (superieur strict) entre deux entiers charges precedemment.\n"
            + "\tSUBR IGtr\n";
    }

    @Override
    public String generateGeq() {
        return "; comparaison (superieur ou egal) entre deux entiers charges precedemment.\n"
            + "\tSUBR IGeq\n";
    }

    @Override
    public String generateIntToBool() {
        return "; conversion d'un entier precedemment charge en booleen.\n"
            + "\tSUBR I2B\n";
    }

    @Override
    public String generateDisplay(String value) {
        return "; affichage d'un entier sur stdout\n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR IOut\n";
    }

    @Override
    public String generateDisplay(int dep, int size) {
        return "; affichage d'un entier sur stdout\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR IOut\n";
    }

    @Override
    public String generateRead() {
        return "; lecture sur stdin d'un entier \n"
            + "SUBR IIn\n";
    }
}
