package mcs.gc.general;

import mcs.tds.*;

/**
 * Interface pour les actions générales (actions sur les variables et les
 * structures de controle principalement)
 * @author antoine
 */
public interface HelperGeneralInterface {

    /**
     * Genere une declaration de variable
     *
     * @param n le nom de la variable
     */
    public String generateDeclaration(String n, VAR i, String t);

    /**
     * Genere une etiquette au nom incremental
     */
    public String generateLabel();

    /**
     * Genere la fin du programme.
     */
    public String generateEnd();

    /**
     * Charge un entier de valeur v sur le sommet de pile
     *
     * @param v
     * @return
     */
    public String generateConstante(String v);

    /**
     * Code pour generer une condition.
     *
     * @param code
     * @param code2
     * @param code3
     * @return
     */
    public String generateIf(String code, String code2, String code3);


    /**
     * code pour generer un commentaire
     *
     * @param c
     * @return
     */
    public String generateComment(String c);
}
