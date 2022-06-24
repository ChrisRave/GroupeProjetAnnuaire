package fr.isika.cda18.projet1.entites;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class LanceurRaf {

	public static void main(String[] args) {

		List<Stagiaire> stagiaires = new ArrayList<>();
		Stagiaire s1 = new Stagiaire("GHAZALA", "Houssam", "91", "ATOD 6", "2009");
		Stagiaire s2 = new Stagiaire("CHABAUD", "Julien", "75", "AI 91", "2014");
		Stagiaire s3 = new Stagiaire("MADELAIGUE", "Pascal", "92", "BOBI 3", "2007");
		Stagiaire s4 = new Stagiaire("DAVID", "Aur�lie", "75", "ATOD 2", "2008");

		Collections.addAll(stagiaires, s1, s2, s3, s4);

		try {
			RandomAccessFile raf = new RandomAccessFile("src/mesFichiers/STAGIAIRES.bin", "rw");
			for (Stagiaire stagiaire : stagiaires) {
				raf.writeChars(stagiaire.agrandirNom());
				raf.writeChars(stagiaire.agrandirPrenom());
				raf.writeChars(stagiaire.getDepartement());
				raf.writeChars(stagiaire.agrandirPromo());
				raf.writeChars(stagiaire.getAnnee());
			}
//			raf.seek(0 * Stagiaire.TAILLE_OBJET_OCTET);
//			String nom4 = "";
//			String prenom4 = "";
//			String departement4 = "";
//			String promo4 = "";
//			String annee4 = "";
//			for (int i = 0; i < Stagiaire.TAILLE_NOM; i++) {
//				nom4 += raf.readChar();
//			}
//			for (int i = 0; i < Stagiaire.TAILLE_PRENOM; i++) {
//				prenom4 += raf.readChar();
//			}
//			for (int i = 0; i < Stagiaire.TAILLE_DEPARTEMENT; i++) {
//				departement4 += raf.readChar();
//			}
//			for (int i = 0; i < Stagiaire.TAILLE_PROMO; i++) {
//				promo4 += raf.readChar();
//			}
//			for (int i = 0; i < Stagiaire.TAILLE_ANNEE; i++) {
//				annee4 += raf.readChar();
//			}

//			System.out.println("Stagiaire " + nom4.trim() + " prenom : " + prenom4.trim() + " departement : "
//					+ departement4 + " promotion : " + promo4.trim() + ", annee : " + annee4);

			raf.seek(0);
			for (int j = 0; j < raf.length() / Stagiaire.TAILLE_OBJET_OCTET; j++) {
				String nom = "";
				String prenom = "";
				String departement = "";
				String promo = "";
				String annee = "";
				for (int i = 0; i < Stagiaire.TAILLE_NOM; i++) {
					nom += raf.readChar();
				}
				for (int i = 0; i < Stagiaire.TAILLE_PRENOM; i++) {
					prenom += raf.readChar();
				}
				for (int i = 0; i < Stagiaire.TAILLE_DEPARTEMENT; i++) {
					departement += raf.readChar();
				}
				for (int i = 0; i < Stagiaire.TAILLE_PROMO; i++) {
					promo += raf.readChar();
				}
				for (int i = 0; i < Stagiaire.TAILLE_ANNEE; i++) {
					annee += raf.readChar();
				}

				System.out.println("Stagiaire " + nom.trim() + " prenom : " + prenom.trim() + " departement : "
						+ departement + " promotion : " + promo.trim() + ", annee : " + annee);
			}
			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}