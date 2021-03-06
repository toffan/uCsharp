package mcs.gc.tam;

import mcs.gc.general.*;
import mcs.tds.*;

import java.util.List;

/**
 * Created by Antoine on 18/05/2016.
 */
public class TamHelperFunction implements HelperFunctionInterface {

    /**
     * @{inheriDoc}
     */
    public String generateFunction(String functionName, String functionTag,
                                   String code) {
        return "; Code de la fonction :  " + functionName + "\n"
            + "JUMP __" + functionTag + "\n"
            + "_" + functionTag + ":\n" + code + "; Fin code fonction " +
            functionName + "\n"
            + "__" + functionTag + ":\n";
    }

    public String generateReturn(int sizeParams, int sizeReturn,
                                 String codeRetour) {
        return "; Retour " + codeRetour + "\n"
            + "    RETURN (" + sizeReturn + ") " + sizeParams + "\n";
    }

    public String generateCall(String functionName, String functionTag,
                               String codeParam) {
        String code = "; Appel fonction : " + functionName + "\n"
                      + "; Chargement des parametres :\n" + codeParam +
                      "; Appel effectif fonction : " + functionName + "\n"
                      + "    CALL (SB) _" + functionTag + "\n";
        return code;
    }
}
