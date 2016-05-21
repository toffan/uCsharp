package Tam;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

import general.HelperGeneralInterface;
import mcs.tds.VAR;

public class TamHelperGeneral implements HelperGeneralInterface {

	// compteur pour le generateur d'etiquettes
	private int labelCounter = 0;
	
    // nom du fichier a compiler en TAM
	private String filename;
	
	
	public TamHelperGeneral(String filename){
		this.filename = filename;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String generateDeclaration(String n, VAR i, String t) {
		int taille = i.addr().dplt();
		return "   ; declaration de " + n + " en " + i.addr().dplt() + "/SB"
				+ " taille = " + taille + "\n";
	}

	/**
	 * {@inheritDoc}
	 */
	public String generateLabel() {
		return "X" + this.labelCounter++;
	}

	/**
	 * {@inheritDoc}
	 */
	public String generateEnd() {
		return "\tHALT\n";
	}

    /**
     * {@inheritDoc}
     */
	public void generateFile(String code) {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(this.filename + ".tam"));
			pw.println(";;; code TAM engendre pour " + this.filename + "\n");
			pw.print(code + "\tHALT\n");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

    /**
     * {@inheritDoc}
     */
	public String generateConstante(String v) {
		return "\tLOADL " + v + "\n";
	}


    /**
     * {@inheritDoc}
     */
	public String generateIf(String code, String code2, String code3) {
		String sinon = this.generateLabel();
		String fin = this.generateLabel();
		return "\t; if\n" + code + "\n" + "\tJUMPIF(0) " + sinon + "\n" + code2
				+ "\n" + "\tJUMP " + fin + "\n" + sinon + "\n" + code3 + "\n"
				+ fin + "\n" + "\t; fin if\n";
	}

    /**
     * {@inheritDoc}
     */
	public String generateComment(String c) {
		return "; " + c + "\n";
	}




}