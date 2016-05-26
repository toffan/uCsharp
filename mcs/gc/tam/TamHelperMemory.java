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
        return "\tLOAD(" + taille + ") " + dep + "[SB]\n";
    }

    /**
     * {@inheritDoc}
     */
    public String generateStaticWrite(int dep, int taille) {
        return "\tSTORE(" + taille + ") " + dep + "[SB]\n";
    }

    /**
     * {@inheritDoc}
     */
    public String generateDynamicRead(int taille) {
        return "\tLOADI(" + taille + ")\n";
    }

    /**
     * {@inheritDoc}
     */
    public String generateDynamicWrite(int taille) {
        return "\tSTOREI(" + taille + ")\n";
    }

    @Override
    public String generateVoid() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String generateMalloc(String size) {
        return "; allocation de la mémoire d'un bloc dee taille " + size + "\n"
            + "\tLOADL " + size + "\n"
            + "\tSUBR MAlloc\n";
    }

    @Override
    public String generateFree(String size) {
        return "; libération de la mémoire \n"
            + "\tLOADL " + size + "\n"
            + "\tSUBR MFree\n";
    }

    @Override
    public String generateAdr(int dep) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String generateAdrField(int dep) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String generateReserve(int size) {
        return "; reservation de " + size + " mots sur la pile\n"
            + "\tPUSH " + size + "\n";
    }

    @Override
    public String generateFree(int size) {
        return "; liberation de " + size + " mots sur la pile\n"
            + "\tPOP " + size + "\n";
    }
}