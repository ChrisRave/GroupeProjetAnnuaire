package fr.isika.cda18.projet1.test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import fr.isika.cda18.projet1.entites.Stagiaire;
public class LanceurRaf {
	public static void main(String[] args) {
	
		//TreeSet tsetStagiaire = new TreeSet();
		//Stagiaire s1 = new Stagiaire("GHAZALA", "Houssam", 91, "ATOD 6", 2009);
		//Collections.addAll(tsetStagiaire, S1);
		List <Stagiaire> stagiaires = new ArrayList<>();
		Stagiaire s1 = new Stagiaire("GHAZALA", "Houssam", 91, "ATOD 6", 2009);
		Stagiaire s2 = new Stagiaire("CHABAUD", "Julien", 75, "AI 91", 2014);
		Stagiaire s3 = new Stagiaire("MADELAIGUE", "Pascal", 92, "BOBI 3", 2007);
		Stagiaire s4 = new Stagiaire("DAVID", "Aur�lie", 75, "ATOD 2", 2008);
		
		Collections.addAll(stagiaires, s1, s2, s3, s4);
		
		try {
			RandomAccessFile raf = new RandomAccessFile("src/mesFichiers/STAGIAIRES.bin", "rw");
			for(Stagiaire stagiaire : stagiaires) {
				raf.writeChars(stagiaire.agrandirNom());
				raf.writeChars(stagiaire.agrandirPrenom());
				raf.writeInt(stagiaire.getDepartement());
				raf.writeChars(stagiaire.agrandirPromo());
				raf.writeInt(stagiaire.getAnnee());
			}
			raf.seek(0 * Stagiaire.TAILLE_OBJET_OCTET);
			String nom4 = "";
			String prenom4 = "";
			int departement4 = 0;
			String promo4 = "";
			int annee4 = 0;
			for (int i =0; i<Stagiaire.TAILLE_NOM; i++) {
				nom4 += raf.readChar();
			}
			for (int i =0; i<Stagiaire.TAILLE_PRENOM; i++) {
				prenom4 += raf.readChar();
			}
			departement4 = raf.readInt();
			for (int i =0; i<Stagiaire.TAILLE_PROMO; i++) {
				promo4 += raf.readChar();
			}
			annee4 = raf.readInt();
			
			
			System.out.println("Stagiaire "  + nom4.trim() + " Prenom : " +prenom4.trim() + "Departement : " + departement4   +"promotion : "
					+ promo4.trim() + ", annee : " + annee4);
			
			
			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}