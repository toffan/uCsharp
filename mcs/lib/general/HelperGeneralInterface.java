package general;

/**
 * Interface pour les actions générales (actions sur les variables et les structures de controle principalement)
 * @author antoine
 */
public interface HelperGeneralInterface {
	
	/**
	 * Genere une declaration de variable
	 * @param n le nom de la variable
	 */
	public String generateDeclaration(String n, INFOVAR i, String t);

	/**
	 * Genere une etiquette au nom incremental
	 */
	public String generateLabel();

	/**
	 * Genere la fin du programme.
	 */
	public String generateEnd();

    /**
     * Ecrit le code entier dans un fichier du nom donne au debut.
     * @param code
     */
	public void generateFile(String code);

    
	/**
	 * Genere une constante de nom v
	 * @param v
	 * @return
	 */
	public String generateConstante(String v);

	/**
	 * Code pour generer une condition.
	 * @param code
	 * @param code2
	 * @param code3
	 * @return
	 */
	public String generateIf(String code, String code2, String code3);


    /**
     * code pour generer un commentaire
     * @param c
     * @return
     */
	public String generateComment(String c);
}
