package mcs.gc.general;
/**
 * Interface à respecter pour un generateur de code assembleur
 */
public interface GeneratorItf{
	/**
	 * Ecrit le code entier dans un fichier du nom donne au debut.
	 *
	 * @param code
	 */
	public void generateFile(String code);
}
