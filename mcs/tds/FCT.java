package mcs.tds;

import java.util.ArrayList;


public class FCT extends VAR {

    ///   Attributs   ///
    private ArrayList<String> params;
    private TDS tds;
    private String name;

    ///   Constructeurs   ///
    public FCT(FTYPE type, TDS parente, String name) {
        super(type);
        this.params = new ArrayList<String>();
        this.tds = new TDS(parente, true);
        this.name = name;
    }

    ///   Methodes   ///

    /**
     * Ajoute un parametre a la fonction et met a jour sa TDS interne.
     */
    public void putParam(String id) {
        int n = this.params.size();
        // Ajout du parametre a la liste de la fonction.
        this.params.add(id);

        // Mise a jour de la TDS en consequences.
        try {
            this.tds.putVar(id, this.type().getParam(n));
        } catch (IndexOutOfBoundsException e) {
            /* Erreur dans l'ordre d'enregistrement dans MCS.egg ! */
            System.err.println("Le type lie au parametre " + id +
                               "n'a pas ete enregistre dans la fonction !");
            throw e;
        }
    }
    public String getParam(int i) { return this.params.get(i); }
    public boolean contains(String id) {
        boolean res = false;
        for (String p : params) {
            res = id.equals(p);
            if (res)
                break;
        }
        return res;
    }

    public TDS tds() { return this.tds; }
    public FTYPE type() {
        // Si le cast echoue, c'est du a une erreur de conception.
        return (FTYPE) super.type();
    }
    public String name() { return this.name; }
}
