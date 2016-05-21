package Tam;

import general.HelperIntInterface;
import general.HelperMemoryInterface;

/**
 * Implementation des fonctions sur la mémoire de la machine TAM
 *
 * @author antoine
 */
public class TamHelperMemory implements HelperMemoryInterface {

    /**
     * {@inheritDoc}
     */
    public String generateStaticRead(int dep, int taille) {

        return "; static read \n" +
                "\tLOAD(" + taille + ") " + dep + "[SB]\n";
    }

    /**
     * {@inheritDoc}
     */
    public String generateStaticWrite(int dep, int taille) {

        return "; static write " +
                "\tSTORE(" + taille + ") " + dep + "[SB]\n";
    }

    /**
     * {@inheritDoc}
     */
    public String generateDynamicRead(int taille) {

        return ";dynamic read de taille" + taille + "\n" +
                "\tLOADI(" + taille + ")\n";
    }

    /**
     * {@inheritDoc}
     */
    public String generateDynamicWriteMem(int taille) {

        return "; dynamic write " +
                "\tSTOREI(" + taille + ")\n";
    }

    @Override
    public String generateVoid() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String generateMalloc(String size) {
        return "; allocation de la mémoire d'un bloc dee taille " + size + "\n"
                + "\tLOADL " + size + "\n" +
                "\tSUBR MAlloc\n";
    }

    @Override
    public String generateFree(String size) {
        return "; libération de la mémoire \n"
                + "\tLOADL " + size + "\n" +
                "\tSUBR MFree\n";
    }

    @Override
    public String generateAdr(int dep) {
        return ";; TODO implementer generateadr";
    }

    @Override
    public String generateAdrField(int dep) {
        return ";; TODO implementer lecture de champ de struct";
    }

    @Override
    public String generateReserve(int size) {
        return "; reservation de " + size + " mots sur la pile\n" +
                "\tPUSH " + size + "\n";
    }

    @Override
    public String generateFree(int size) {
        return "; liberation de " + size + " mots sur la pile\n" +
                "\tPOP " + size + "\n";
    }
}