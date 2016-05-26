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
        return "; code de la fonction :  " + functionName + " \n"
            + "_" + functionTag + ":\n" + code + "; fin code fonction " +
            functionName + " \n";
    }

    public String generateReturn(int sizeParams, int sizeReturn,
                                 String codeRetour) {
        return "; retour" + codeRetour + "\tRETURN (" + sizeParams + ")" +
            sizeReturn + "\n";
    }

    public String generateCall(String functionName, String functionTag,
                               List<VAR> parameters) {
        String code =
            "; Appel fonction : " + functionName + " avec les parametres :\n";
        for (VAR p : parameters) {
            code += ";\t " + p.name() + " : " + p.type().name() + "\n";
            // p.addr()
            // code += "PUSH ";
        }
        code += "\tCALL(SB) _" + functionTag + "\n";
        return code;
    }
}
