package mcs.gc.general;

public interface HelperMemoryInterface {
    /**
     * Void : renvoie la valeur "adresse non initialisée"
     * Malloc : alloue un bloc de taille donnée
     * 	- (une adresse)
     * 	- (une valeur)
     * Free : libère un bloc de mémoire de taille donnée
     * 	- (une adresse)
     * 	- (une valeur)
     * Compare : Test égalité entre le contenu de 2 blocs mémoire
     * 	- 2 adresses
     * Copy : Copie le contenu d’un bloc mémoire dans le second bloc mémoire
     * 	- 2 adresses
     */

    public String generateVoid();

    /**
     * @param size taille de la zone à allouer
     * @return
     */
    public String generateMalloc(String size);

    /**
     * Libère un bloc mémoire de taille size.
     * @param size la taille du bloc mémoire à libérer.
     * @return
     */
    public String generateFree(String size);

    /**
     * code pour lire la valeur d'une expression dont on connait l'adresse à la
     * compilation : variable, champ d'un struct etc
     * @param dep
     * @param taille
     * @return
     */

    public String generateStaticRead(int dep, int taille);

    /**
     * code pour ecrire la valeur d'une expression dont on connait l'adresse à
     * la compilation : variable, champ d'un struct etc
     * @param dep
     * @param taille
     * @return
     */
    public String generateStaticWrite(int dep, int taille);

    /**
     * code pour lire la valeur d'une expression dont on connait l'adresse à
     * l'execution seulement : pointeurs
     * @param taille
     * @return
     */
    public String generateDynamicRead(int taille);

    /**
     * code pour ecrire la valeur d'une expression dont on connait l'adresse à
     * l'execution seulement : pointeurs
     * @param taille
     * @return
     */
    public String generateDynamicWrite(int taille);


    /**
     * Code pour empiler une adresse
     * @param dep
     * @return
     */
    public String generateAdr(int dep);

    /**
     * code pour calculer l'adresse d'un champ d'un struct
     * @param dep
     * @return
     */
    public String generateAdrField(int dep);


    /**
     * code pour réserver de la mémoire dans la pile (push)
     * @param size la taille à réserver
     */
    public String generateReserve(int size);

    /**
     * code pour liberer de la mémoire sur la pile
     * @param size la taille à liberer
     * @return
     */
    public String generateFree(int size);
}
