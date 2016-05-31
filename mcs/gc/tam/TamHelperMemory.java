package mcs.gc.tam;

import mcs.gc.general.*;


/**
 * Implementation des fonctions sur la mémoire de la machine TAM
 * @author antoine
 */
public class TamHelperMemory implements HelperMemoryInterface {

    /**
     * {@inheritDoc}
     */
    public String generateStaticRead(int dep, int taille) {
        return "    LOAD(" + taille + ") " + dep + "[SB]\n";
    }

    /**
     * {@inheritDoc}
     */
    public String generateStaticWrite(int dep, int taille) {
        return "    STORE(" + taille + ") " + dep + "[SB]\n";
    }

    /**
     * {@inheritDoc}
     */
    public String generateDynamicRead(int taille) {
        return "    LOADI(" + taille + ")\n";
    }

    /**
     * {@inheritDoc}
     */
    public String generateDynamicWrite(int taille) {
        return "    STOREI(" + taille + ")\n";
    }

    @Override
    public String generateVoid() {
        return "; Adresse non initialisee.\n"
            + "    SUBR MVoid\n";
    }

    @Override
    public String generateMalloc(String size) {
        return "; Allocation de la mémoire d'un bloc de taille " + size + "\n"
            + "    LOADL " + size + "\n"
            + "    SUBR MAlloc\n";
    }

    @Override
    public String generateFree(String size) {
        return "; Libération de la mémoire.\n"
            + "    LOADL " + size + "\n"
            + "    SUBR MFree\n";
    }

    @Override
    public String generateAdr(int dep) {
        return "    LOADA " + dep + "[SB]\n";
    }

    @Override
    public String generateAdrField(int dep) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String generateReserve(int size) {
        return "; Reservation de " + size + " mot" + (size > 1 ? "s" : "") +
            " sur la pile.\n"
            + "    PUSH " + size + "\n";
    }

    @Override
    public String generateFree(int size) {
        return "; Liberation de " + size + " mot" + (size > 1 ? "s" : "") +
            " sur la pile.\n"
            + "    POP " + size + "\n";
    }

    @Override
    public String generateDuplicate(int size) {
        return "; Duplication " + (size > 1 ? "des " + size : "du") + " mot" +
            (size > 1 ? "s" : "") + " precedent" + (size > 1 ? "s" : "") + ".\n"
            + "    LOAD (" + size + ") -" + size + "[ST]\n";
    }
}
