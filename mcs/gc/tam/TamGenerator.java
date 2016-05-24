package mcs.gc.tam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import mcs.gc.general.*;


public class TamGenerator implements GeneratorItf {

    // nom du fichier a compiler en TAM
    private String filename;

    // helpers
    private TamHelperBool boolHelper;
    private TamHelperChar charHelper;
    private TamHelperInt intHelper;
    private TamHelperMemory memoryHelper;
    private TamHelperString stringHelper;
    private TamHelperGeneral generalHelper;
    private TamHelperFunction functionHelper;

    /**
     * Utilisation du Generator : construction du generator avec le nom du
     * fichier à générer.
     *
     * Appels des différentes méthodes au travers des helpers :
     * EX : besoin de générer une instruction sur la mémoire,
     * tamGenerator.getMemoryHelper().generateVoid();
     */


    /**
     * @param fname le nom du fichier à générer
     */
    public TamGenerator(String fname) {
        System.out.println("OUT:Creation du tam generator " + fname);
        if (fname.endsWith(".mcs")) {
            this.filename = fname.substring(0, fname.length() - 4);
        } else {
            this.filename = fname;
        }

        // initialisation des helpers
        this.generalHelper = new TamHelperGeneral();
        this.boolHelper = new TamHelperBool();
        this.charHelper = new TamHelperChar();
        this.intHelper = new TamHelperInt();
        this.memoryHelper = new TamHelperMemory();
        this.stringHelper = new TamHelperString();
        this.functionHelper = new TamHelperFunction();
    }


    /**
     * {@inheritDoc}
     */
    public void generateFile(String code) {
        try {
            System.out.println("OUT:Ecriture du code dans le fichier " +
                               this.filename + ".tam");
            PrintWriter pw = new PrintWriter(
                new FileOutputStream(this.getFileName() + ".tam"));
            pw.println(";;; code TAM engendre pour " + this.filename + "\n");
            pw.print(code + "\tHALT\n");
            pw.close();
        } catch (FileNotFoundException e) {
            System.err.println("Impossible d'ecrire dans le fichier " +
                               this.filename + ".tam");
            e.printStackTrace();
        }
    }

    public TamHelperBool getBoolHelper() { return boolHelper; }

    public TamHelperChar getCharHelper() { return charHelper; }

    public TamHelperInt getIntHelper() { return intHelper; }

    public TamHelperMemory getMemoryHelper() { return memoryHelper; }

    public TamHelperString getStringHelper() { return stringHelper; }

    public TamHelperGeneral getGeneralHelper() { return generalHelper; }

    public TamHelperFunction getFunctionHelper() { return functionHelper; }

    public String getFileName() { return this.filename; }
}
