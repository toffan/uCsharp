package mcs.lib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TamGenerator implements GeneratorItf{
    
    // nom du fichier a compiler en TAM
	private String filename;

	// compteur pour le generateur d'etiquettes
	private static int labelCounter = 0;
	
	//helpers
	private TamFunctionsBool functionsHelper;
	private TamFunctionsBool functionsHelper;
	private TamFunctionsBool functionsHelper;

	
    /**
     * @param fname le nom du fichier à générer
     */
	public TamGenerator(String fname) {
		if (fname.endsWith(".c")) {
			filename = fname.substring(0, fname.length() - 2);
		} else {
			filename = fname;
		}
		
		//initialisation des helpers
	}

	/**
	 * Genere une déclaration de variable
	 * @param n le nom de la variable
	 */
	public String generateDeclaration(String n, INFOVAR i, String t) {
		int taille = i.getType().getTaille();
		return "   ; declaration de " + n + " en " + i.getDep() + "/SB"
				+ " taille = " + taille + "\n";
	}

	

	/**
	 * Genere une etiquette
	 */
	public String generateLabel() {
		return "X" + labelCounter++;
	}

	/**
	 * Genere la fin du programme.
	 */
	public String generateEnd() {
		return "\tHALT\n";
	}

        // ecrit le code TAM dans le fichier .tam
	public void generateAsm(String code) {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(nom + ".tam"));
			pw.println(";;; code TAM engendre pour " + this.filename + "\n");
			pw.print(code + "\tHALT\n");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

    /**
     * @param v
     */
	public String generateConstante(String v) {
		return "\tLOADL " + v + "\n";
	}

        // code pour liberer la place reservee pour les variables
	public String generateFree(int i) {
		return "\tPOP(0)" + i + "\n";
	}

        // code pour lire la valeur d'une expression dont on connait l'adresse 
        //  à la compilation : variable, champ d'un struct etc
	public String generateStaticRead(int dep, int taille) {
		return "\tLOAD(" + taille + ") " + dep + "[SB]\n";
	}

        // code pour ecrire la valeur d'une expression dont on connait l'adresse 
        //  à la compilation : variable, champ d'un struct etc
	public String generateStaticWrite(int dep, int taille) {
		return "\tSTORE(" + taille + ") " + dep + "[SB]\n";
	}

        // code pour lire la valeur d'une expression dont on connait l'adresse 
        // à l'execution seulement : pointeurs
	public String generateDynamicRead(int taille) {
		return "\tLOADI(" + taille + ")\n";
	}

        // code pour ecrire la valeur d'une expression dont on connait l'adresse 
        // à l'execution seulement : pointeurs
	public String generateDynamicWriteMem(int taille) {
		return "\tSTOREI(" + taille + ")\n";
	}

        // code pour une conditionnelle
	public String generateIf(String code, String code2, String code3) {
		String sinon = genEtiq();
		String fin = genEtiq();
		return "\t; if\n" + code + "\n" + "\tJUMPIF(0) " + sinon + "\n" + code2
				+ "\n" + "\tJUMP " + fin + "\n" + sinon + "\n" + code3 + "\n"
				+ fin + "\n" + "\t; fin if\n";
	}

      
        // code pour allouer dans le tas
	public String generateMalloc(int taille) {
		return "\tLOADL " + taille + "\n" + "\tSUBR Malloc\n";
	}

        // code pour empiler une adresse
	public String generateAdr(int dep) {
		return "\tLOADA " + dep + "[SB]\n";
	}

        // code pour calculer l'adresse d'un champ d'un struct
	public String genAdrField(int dep) {
		return "\t;Calcul deplacement struct " + dep + "\n" + "\tLOADL " + dep
				+ "\n\tSUBR Iadd\n";
	}

        // code pour generer un commentaire
	public String generateComment(String c) {
		return "; " + c + "\n";
	}
}
