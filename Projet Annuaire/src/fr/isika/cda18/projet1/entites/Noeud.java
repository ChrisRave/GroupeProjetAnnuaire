package fr.isika.cda18.projet1.entites;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Noeud implements InterfaceTailles {
	private Stagiaire stagiaire;
	private int filsGauche;
	private int filsDroit;

	// Constructeur
	public Noeud(Stagiaire stagiaire, int filsGauche, int filsDroit) {
		this.stagiaire = stagiaire;
		this.filsGauche = filsGauche;
		this.filsDroit = filsDroit;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public int getFilsGauche() {
		return filsGauche;
	}

	public void setFilsGauche(int filsGauche) {
		this.filsGauche = filsGauche;
	}

	public int getFilsDroit() {
		return filsDroit;
	}

	public void setFilsDroit(int filsDroit) {
		this.filsDroit = filsDroit;
	}

	// Méthodes spécifiques
	public static void ecritureBinaire(Noeud noeud) throws IOException {

		try {

			LanceurBinaire.raf.writeChars(noeud.getStagiaire().agrandirNom());
			LanceurBinaire.raf.writeChars(noeud.getStagiaire().agrandirPrenom());
			LanceurBinaire.raf.writeChars(noeud.getStagiaire().getDepartement());
			LanceurBinaire.raf.writeChars(noeud.getStagiaire().agrandirPromo());
			LanceurBinaire.raf.writeChars(noeud.getStagiaire().getAnnee());
			LanceurBinaire.raf.writeInt(noeud.filsGauche);
			LanceurBinaire.raf.writeInt(noeud.filsDroit);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void lectureBinaire() throws IOException {
		
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile("src/mesFichiers/listeStagiaires.bin", "rw");
			LanceurBinaire.raf.seek(0);
			for (int j = 0; j < raf.length() / Stagiaire.TAILLE_OBJET_OCTET; j++) {
				String nom = "";
				String prenom = "";
				String departement = "";
				String promo = "";
				String annee = "";
				for (int i = 0; i < Stagiaire.TAILLE_NOM; i++) {
					nom += LanceurBinaire.raf.readChar();
				}
				for (int i = 0; i < Stagiaire.TAILLE_PRENOM; i++) {
					prenom += LanceurBinaire.raf.readChar();
				}
				for (int i = 0; i < Stagiaire.TAILLE_DEPARTEMENT; i++) {
					departement += LanceurBinaire.raf.readChar();
				}
				for (int i = 0; i < Stagiaire.TAILLE_PROMO; i++) {
					promo += LanceurBinaire.raf.readChar();
				}
				for (int i = 0; i < Stagiaire.TAILLE_ANNEE; i++) {
					annee += LanceurBinaire.raf.readChar();
				}
				int filsGauche = LanceurBinaire.raf.readInt();
				int filsDroit = LanceurBinaire.raf.readInt();

				System.out
						.println("Nom :" + nom.trim() + "\t Prenom :" + prenom.trim() + "\t Departement :" + departement
								+ "\t Promotion :" + promo.trim() + "\t Annee : " + annee + filsDroit + filsGauche);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "*****Lecture Noeud*****\n"  + "Noeud"+ stagiaire + "\t Index gauche: " + filsGauche + "\t Index droit: " + filsDroit;
	}

	public static Noeud lectureNoeud() throws IOException {
		
		Stagiaire stg = null;
		int filsGauche = -1;
		int filsDroit = -1;
		try {
			String nom = "";
			String prenom = "";
			String departement = "";
			String promo = "";
			String annee = "";
			for (int i = 0; i < Stagiaire.TAILLE_NOM; i++) {
				nom += LanceurBinaire.raf.readChar();
			}
			for (int i = 0; i < Stagiaire.TAILLE_PRENOM; i++) {
				prenom += LanceurBinaire.raf.readChar();
			}
			for (int i = 0; i < Stagiaire.TAILLE_DEPARTEMENT; i++) {
				departement += LanceurBinaire.raf.readChar();
			}
			for (int i = 0; i < Stagiaire.TAILLE_PROMO; i++) {
				promo += LanceurBinaire.raf.readChar();
			}
			for (int i = 0; i < Stagiaire.TAILLE_ANNEE; i++) {
				annee += LanceurBinaire.raf.readChar();
			}
			filsGauche = LanceurBinaire.raf.readInt();
			filsDroit = LanceurBinaire.raf.readInt();
			stg = new Stagiaire(nom, prenom, departement, promo, annee);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Noeud noeud = new Noeud(stg, filsGauche, filsDroit);
		return noeud;
	}

	public void affichageInfixe() throws IOException {

		if (this.getFilsGauche() != -1) {
			LanceurBinaire.raf.seek(this.getFilsGauche() * Stagiaire.TAILLE_OBJET_OCTET);
			Noeud filsGauche = lectureNoeud();
			filsGauche.affichageInfixe();
		}

		System.out.println(this);
		if (this.getFilsDroit() != -1) {
			LanceurBinaire.raf.seek(this.getFilsDroit() * Stagiaire.TAILLE_OBJET_OCTET);
			Noeud filsDroit = lectureNoeud();
			filsDroit.affichageInfixe();
		}

	}
}