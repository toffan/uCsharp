package mcs.gc.tam;

import mcs.gc.general.*;

/**
 * Implementation des fonctions sur les entiers de la machine TAM
 *
 * @author antoine
 */
public class TamHelperInt implements HelperIntInterface {


    @Override
    public String generateSum(int dep, int size, String value) {
        return "; somme (" + dep + "," + size + ") + " + value + "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR IAdd\n";
    }

    @Override
    public String generateSum(String value1, String value2) {
        return "; somme " + value1 + " + " + value2 + "\n"
            + "\tLOADL " + value1 + "\n"
            + "\tLOADL " + value2 + "\n"
            + "\tSUBR IAdd";
    }

    @Override
    public String generateSum(int dep1, int size1, int dep2, int size2) {
        return "; somme (" + dep1 + "," + size1 + ") + (" + dep2 + "," + size2 +
            ")\n"
            + "\tLOAD(" + size1 + ") " + dep1 + "[LB] \n"
            + "\tLOAD(" + size2 + ") " + dep2 + "[LB] \n"
            + "\tSUBR IAdd\n";
    }

    @Override
    public String generateSub(int dep, int size, String value) {
        return "; soustraction (" + dep + "," + size + ") - " + value + "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR ISub\n";
    }

    @Override
    public String generateSub(String value, int dep, int size) {
        return "; soustraction " + value + " - (" + dep + "," + size + ") \n"
            + "\tLOADL " + value + "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR ISub\n";
    }

    @Override
    public String generateSub(String value1, String value2) {
        return "; soustraction " + value1 + " + " + value2 + "\n"
            + "\tLOADL " + value1 + "\n"
            + "\tLOADL " + value2 + "\n"
            + "\tSUBR ISub\n";
    }

    @Override
    public String generateSub(int dep1, int size1, int dep2, int size2) {
        return "; soustraction (" + dep1 + "," + size1 + ") + (" + dep2 + "," +
            size2 + ")\n"
            + "\tLOAD(" + size1 + ") " + dep1 + "[LB] \n"
            + "\tLOAD(" + size2 + ") " + dep2 + "[LB] \n"
            + "\tSUBR ISub\n";
    }

    @Override
    public String generateDiv(int dep, int size, String value) {
        return "; division entiere (" + dep + "," + size + ") par " + value +
            "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR IDiv\n";
    }

    @Override
    public String generateDiv(String value, int dep, int size) {
        return "; division entiere  " + value + " par (" + dep + "," + size +
            ")\n"
            + "\tLOADL " + value + "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR IDiv\n";
    }

    @Override
    public String generateDiv(String value1, String value2) {
        return "; division entiere " + value1 + " par " + value2 + "\n"
            + "\tLOADL " + value1 + "\n"
            + "\tLOADL " + value2 + "\n"
            + "\tSUBR IDiv\n";
    }

    @Override
    public String generateDiv(int dep1, int size1, int dep2, int size2) {
        return "; division entiere (" + dep1 + "," + size1 + ") par (" + dep2 +
            "," + size2 + ")\n"
            + "\tLOAD(" + size1 + ") " + dep1 + "[LB] \n"
            + "\tLOAD(" + size2 + ") " + dep2 + "[LB] \n"
            + "\tSUBR IDiv\n";
    }

    @Override
    public String generateMul(int dep, int size, String value) {
        return "; multiplication de (" + dep + "," + size + ") par " + value +
            "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR IMul";
    }

    @Override
    public String generateMul(String value1, String value2) {
        return "; multiplication de " + value1 + " par " + value2 + "\n"
            + "\tLOADL " + value1 + "\n"
            + "\tLOADL " + value2 + "\n"
            + "\tSUBR IMul\n";
    }

    @Override
    public String generateMul(int dep1, int size1, int dep2, int size2) {
        return "; multiplication de  (\"+dep1+\",\"+size1+\")par (" + dep2 +
            "," + size2 + ")\n"
            + "\tLOAD(" + size1 + ") " + dep1 + "[LB] \n"
            + "\tLOAD(" + size2 + ") " + dep2 + "[LB] \n"
            + "\tSUBR IMul\n";
    }

    @Override
    public String generateMod(int dep, int size, String value) {
        return "; modulo de (" + dep + "," + size + ") par " + value + "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR IMod\n";
    }

    @Override
    public String generateMod(String value, int dep, int size) {
        return "; modulo de " + value + " par (" + dep + "," + size + ") \n"
            + "\tLOADL " + value + "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tSUBR IMod\n";
    }

    @Override
    public String generateMod(String value1, String value2) {
        return "; modulo de " + value1 + " par " + value2 + "\n"
            + "\tLOADL " + value1 + "\n"
            + "\tLOADL " + value2 + "\n"
            + "\tSUBR IMod\n";
    }

    @Override
    public String generateMod(int dep1, int size1, int dep2, int size2) {
        return "; modulo de (" + dep1 + "," + size1 + ") par (" + dep2 + "," +
            size2 + ")\n"
            + "\tLOAD(" + size1 + ") " + dep1 + "[LB] \n"
            + "\tLOAD(" + size2 + ") " + dep2 + "[LB] \n"
            + "\tSUBR IMod\n";
    }

    @Override
    public String generateComEqu(int dep, int size, String value) {
        return "; comparaison egalite (" + dep + "," + size + ") et " + value +
            "\n"
            + "\tLOAD(" + size + ") " + dep + "[LB] \n"
            + "\tLOADL " + value + "\n"
            + "\tSUBR IEq\n";
    }


    @Override
    public String generateComEqu(String value1, String value2) {
        return "; comparaison egalite " + value1 + " et " + value2 + "\n"
            + "\tLOADL " + value1 + "\n"
            + "\tLOADL " + value2 + "\n"
            + "\tSUBR IEq\n";
    }

    @Override
    public String generateComEqu(int dep1, int size1, int dep2, int size2) {
        return "; comparaison egalite (" + dep1 + "," + size1 + ") et (" +
            dep2 + "," + size2 + ")\n"
            + "\tLOAD(" + size1 + ") " + dep1 + "[LB] \n"
            + "\tLOAD(" + size2 + ") " + dep2 + "[LB] \n"
            + "\tSUBR Ieq\n";
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