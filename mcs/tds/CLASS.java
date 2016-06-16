package mcs.tds;

public class CLASS extends STRUCT {

    // Attributs //

    // Type de this.
    private PTR thisType;
    // Est-ce que je refuse l'acces aux symboles prives ?
    private boolean defensive = false;

    // Constructeurs //
    public CLASS(TDS parent, String name) {
        super(name);
        PTR localPtr = new PTR(this);
        thisType = (PTR) parent.searchType(localPtr.name(), true);
        if(thisType == null) {
            parent.putType(localPtr.name(), localPtr);
            thisType = localPtr;
        }
    };

    // Methodes //

    /**
     * @param String id l'identifiant du symbole recherche dans la classe
     * searchvar recherche un symbole (methode/attribut) dans la classe.
     * Si l'attribut n'existe pas, ou qu'il est public ou qu'il est prive mais
     * que la classe n'est pas en mode defensive, alors l'attribut est retourne.
     * Sinon erreur.
     */
    public VAR searchVar(String id) {
        VAR result = this.tds.searchVar(id, false);
        if(result == null
            || result.pub()
            || ( !result.pub() && !this.defensive ) ) {
            return result;
        }
        else{
            throw new RuntimeException("Ce symbole est prive.");
        }
    }

    /**
     * Cloture la classe :
     * La mets en mode defensive ce qui interdit l'acces a des attributs prives
     */
    public void close() {
        this.defensive = true;
    }

    public PTR getThisType() {
        return thisType;
    };

    public void putVar(String id, TYPE type, boolean isPub) {
        this.tds.putVar(id, type, isPub);
        this.size += type.size();
    }

    public void putVar(String id, TYPE type) {
        this.putVar(id, type, true);
    }

    public void putType(String id, TYPE type, boolean isPub) {
        this.tds.putType(id, type, isPub);
        this.size += type.size();
    }

    public void putType(String id, TYPE type) {
        this.putType(id, type, true);
    }

    public void putVar(String id, FCT meth, boolean isPub) {
        this.tds.putVar(id, meth, isPub);

        // TODO: Gestion du polymorphisme.
    }

    public void putVar(String id, FCT meth) {
        this.putVar(id, meth, true);
    }
}
