package mcs.libasm.tds;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * une ASMTDS hiérarchique.
 *
 * @author marcel
 *
 */
public class ASMTDS extends HashMap<String, INFO> {

    private static final long serialVersionUID = 1L;

    /**
     * La ASMTDS parente
     */
    private ASMTDS parente;

    /**
     * Constructeur pour une ASMTDS sans parente
     */
    public ASMTDS() { this(null); }

    /**
     * Constructeur pour une ASMTDS fille de p
     *
     * @param p
     */
    public ASMTDS(ASMTDS p) {
        super();
        parente = p;
    }

    public ASMTDS getParente() { return parente; }

    /**
     * Recherche de n dans la ASMTDS courante uniquement
     *
     * @param n
     * @return
     */
    public INFO chercherLocalement(String n) { return get(n); }

    /**
     * Recherche de n dans la ASMTDS courante et ses parentes.
     *
     * @param n
     * @return
     */
    public INFO chercherGlobalement(String n) {
        INFO i = chercherLocalement(n);
        if (i == null)
            if (parente != null)
                return parente.chercherGlobalement(n);
        return i;
    }

    /**
     * Ajoute le nom n et son information i dans la ASMTDS
     *
     * @param n
     * @param i
     */
    public void inserer(String n, INFO i) { put(n, i); }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Set<Map.Entry<String, INFO>> s = entrySet();
        for (Map.Entry<String, INFO> e : s) {
            sb.append("; " + e.getKey() + " : " + e.getValue() + '\n');
        }
        return sb.toString();
    }
}
