package general;

public interface HelperIntInterface {

	/** sommer 2 entiers	(un adresse, une valeur) **/
	public String generateSum(int dep, int size,String value);
	
	 /** sommer 2 entiers	(2 valeurs) **/
	public String generateSum(String value1, String value2);

	 /** sommer 2 entiers	(2 adresses) **/
	public String generateSum(int dep1, int size1, int dep2, int size2);

	 /** soustraire 2 entiers (un adresse, une valeur) **/
	public String generateSub(int dep, int size,String value);
	
	 /** soustraire 2 entiers	(2 valeurs) **/
	public String generateSub(String value1, String value2);

	 /** soustraire 2 entiers	(2 adresses) **/
	public String generateSub(int dep1, int size1, int dep2, int size2);

	 /** diviser 2 entiers (un adresse, une valeur) **/
	public String generateDiv(int dep, int size,String value);
	
	 /** diviser 2 entiers	(2 valeurs) **/
	public String generateDiv(String value1, String value2);

	 /** diviser 2 entiers	(2 adresses) **/
	public String generateDiv(int dep1, int size1, int dep2, int size2);

	 /** multiplier 2 entiers (un adresse, une valeur) **/
	public String generateMul(int dep, int size,String value);
	
	 /** multiplier 2 entiers	(2 valeurs) **/
	public String generateMul(String value1, String value2);

	 /** multiplier 2 entiers	(2 adresses) **/
	public String generateMul(int dep1, int size1, int dep2, int size2);
	
	 /** comparer 2 entiers (un adresse, une valeur) **/
	public String generateCom(int dep, int size,String value);
	
	 /** comparer 2 entiers	(2 valeurs) **/
	public String generateCom(String value1, String value2);

	 /** comparer 2 entiers	(2 adresses) **/
	public String generateCom(int dep1, int size1, int dep2, int size2);	
	
	 /** modulo 2 entiers (un adresse, une valeur) **/
	public String generateMod(int dep, int size,String value);
	
	 /** modulo 2 entiers	(2 valeurs) **/
	public String generateMod(String value1, String value2);

	 /** modulo 2 entiers	(2 adresses) **/
	public String generateMod(int dep1, int size1, int dep2, int size2);	

}
