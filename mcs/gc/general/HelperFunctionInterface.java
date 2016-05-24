package mcs.gc.general;

import java.util.List;
import mcs.tds.VAR;


/**
 * Created by Antoine on 18/05/2016.
 * Helper pour la génération de fonctions.
 */
public interface HelperFunctionInterface {

    /**
     * Genere la déc laration d'une fonction
     * @param functionName le nom de la fonction
     * @param functionTag son tag (etiquette mise dans l'assembleur pour la
     * declaration)
     * @param code  le code de la fonction
     * @return code généré de la déclaration de la fonction.
     */
    public String generateFunction(String functionName, String functionTag,
                                   String code);

    /**
     * genere un return
     * @param sizeReturn Le nombre de mots mémoire des résultats. Ces mots
     * mémoires sont en sommets de pile et seront recopiés en sommet de pile
     * après le return
     * @param depReturn le nombre de mots mémoires des paramètres.
     * @param codeRetour
     * @return
     */
    public String generateReturn(int sizeReturn, int depReturn,
                                 String codeRetour);


    /**
     *
     * @param functionName le nom de la fonction
     * @param functionTag le tag de la fonction
     * @param parameters la liste des parametres.
     * @return
     */
    public String generateCall(String functionName, String functionTag,
                               List<VAR> parameters);
}
