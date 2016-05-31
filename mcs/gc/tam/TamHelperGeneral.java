package mcs.gc.tam;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

import mcs.gc.general.*;
import mcs.tds.*;

public class TamHelperGeneral implements HelperGeneralInterface {

    // compteur pour le generateur d'etiquettes
    private int labelCounter = 0;

    public TamHelperGeneral() {}

    /**
     * {@inheritDoc}
     */
    public String generateDeclaration(String n, VAR i, String t) {
        int taille = i.addr().val();
        return "; Declaration de " + n + " en " + i.addr().val() + "/SB"
            + " taille = " + taille + "\n";
    }

    /**
     * {@inheritDoc}
     */
    public String generateLabel() { return "X" + this.labelCounter++; }

    /**
     * {@inheritDoc}
     */
    public String generateEnd() { return "    HALT\n"; }

    /**
     * {@inheritDoc}
     */
    public String generateConstante(String v) {
        return "    LOADL " + v + "\n";
    }

    /**
     * {@inheritDoc}
     */
    public String generateConstante(int v) { return "    LOADL " + v + "\n"; }


    /**
     * {@inheritDoc}
     */
    public String generateIf(String condition, String codeIf, String codeElse) {
        String res;
        String labelSinon = this.generateLabel();
        String labelFin = this.generateLabel();
        res = "; if\n" + condition + "\n";
        res += "    JUMPIF(0) " + labelSinon + "\n";
        res += codeIf + "\n"
               + "    JUMP " + labelFin + "\n";
        res += labelSinon + "\n" + codeElse + "\n" + labelFin + "\n";
        res += "    ; fin if\n";
        return res;
    }

    /**
     * {@inheritDoc}
     */
    public String generateComment(String c) { return "; " + c + "\n"; }
}
