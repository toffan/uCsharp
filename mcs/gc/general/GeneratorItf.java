package mcs.gc.general;

import mcs.gc.tam.TamHelperBool;
import mcs.gc.tam.TamHelperChar;
import mcs.gc.tam.TamHelperFunction;
import mcs.gc.tam.TamHelperGeneral;
import mcs.gc.tam.TamHelperInt;
import mcs.gc.tam.TamHelperMemory;
import mcs.gc.tam.TamHelperString;

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
	
	public String getFileName();
	
	public HelperBoolInterface getBoolHelper();

	public HelperCharInterface getCharHelper();

	public HelperIntInterface getIntHelper();

	public HelperMemoryInterface getMemoryHelper();

	public HelperStringInterface getStringHelper();

	public HelperGeneralInterface getGeneralHelper();

	public HelperFunctionInterface getFunctionHelper();
}
