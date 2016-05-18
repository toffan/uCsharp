package Tam;

import general.HelperFunctionInterface;
import mcs.tds.VAR;

import java.util.List;

/**
 * Created by Antoine on 18/05/2016.
 */
public class TamHelperFunction implements HelperFunctionInterface {

    /**
     * @{inheriDoc}
     */
    public String generateFunction(String functionName, String functionTag, String code) {
        return "; code de la fonction :  " + functionName + " \n" +
                "_" + functionTag + ":\n"
                + code
                + "; fin code fonction " + functionName + " \n";
    }

    public String generateReturn(int sizeReturn, int depReturn, String codeRetour) {
        return "; retour"
                + codeRetour
                + "\tRETURN (" + sizeReturn + ")" + depReturn + "\n";
    }

    public String generateCall(String functionName, String functionTag, List<VAR> parameters) {
        String code = "; Appel fonction : " + functionName + " avec les parametres :\n";
        for (VAR p : parameters) {
            code += ";\t <nom parametre>  <type parametre> \n";
        }
        code += "\tCALL(SB) _" + functionTag + "\n";
        return code;
    }


}
