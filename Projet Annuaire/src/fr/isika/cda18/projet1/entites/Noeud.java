package fr.isika.cda18.projet1.entites;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Noeud implements InterfaceTailles {
	private Stagiaire stagiaire;
	private int filsGauche;
	private int filsDroit;

	// Constructeur
	public Noeud(Stagiaire stagiaire, int filsGauche, int filsDroit) {

		this.stagiaire = stagiaire;
		this.filsGauche = -1;
		this.filsDroit = -1;
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

	// M�thodes sp�cifiques
	public void ecritureBinaire() throws IOException {

		try {
			RandomAccessFile raf = new RandomAccessFile("src/mesFichiers/listeStagiaires.bin", "rw");
			LanceurBinaire.raf.writeChars(this.stagiaire.agrandirNom());
			LanceurBinaire.raf.writeChars(this.stagiaire.agrandirPrenom());
			LanceurBinaire.raf.writeChars(this.stagiaire.getDepartement());
			LanceurBinaire.raf.writeChars(this.stagiaire.agrandirPromo());
			LanceurBinaire.raf.writeChars(this.stagiaire.getAnnee());
			LanceurBinaire.raf.writeInt(this.filsDroit);
			LanceurBinaire.raf.writeInt(this.filsGauche);
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void lectureBinaire() throws IOException {

	
		try {
			RandomAccessFile raf = new RandomAccessFile("src/mesFichiers/listeStagiaiares.bin", "rw");
			LanceurBinaire.raf.seek(0);
			for (int j = 0; j < raf.length() / Stagiaire.TAILLE_OBJET_OCTET; j++) {
				String nom = "";
				String prenom = "";
				String departement = "";
				String promo = "";
				String annee = "";
				int filsGauche = -1;
				int filsDroit = -1;
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
				for (int i = 0; i < Stagiaire.TAILLE_OBJET_OCTET; i++) {
					filsGauche += LanceurBinaire.raf.readInt();
				}
				for (int i = 0; i < Stagiaire.TAILLE_OBJET_OCTET; i++) {
					filsDroit += LanceurBinaire.raf.readInt();
				}
				System.out.println("Nom :" + nom.trim() + "\t Prenom :" + prenom.trim() + "\t Departement :"
						+ departement + "\t Promotion :" + promo.trim() + "\t Annee : " + annee);
			}
			raf.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
