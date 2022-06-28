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

	@Override
	public String toString() {
		return "Noeud [stagiaire=" + stagiaire + ", filsGauche=" + filsGauche + ", filsDroit=" + filsDroit + "]";
	}

	// Méthodes spécifiques
	public static  void ecritureBinaire(Noeud noeud) throws IOException {

		try {
			RandomAccessFile raf = new RandomAccessFile("src/mesFichiers/listeStagiaires.bin", "rw");
			LanceurBinaire.raf.writeChars(noeud.getStagiaire().agrandirNom());
			LanceurBinaire.raf.writeChars(noeud.getStagiaire().agrandirPrenom());
			LanceurBinaire.raf.writeChars(noeud.getStagiaire().getDepartement());
			LanceurBinaire.raf.writeChars(noeud.getStagiaire().agrandirPromo());
			LanceurBinaire.raf.writeChars(noeud.getStagiaire().getAnnee());
			LanceurBinaire.raf.writeInt(noeud.filsGauche);
			LanceurBinaire.raf.writeInt(noeud.filsDroit);
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public  void lectureBinaire() throws IOException {

	
		try {
			RandomAccessFile raf = new RandomAccessFile("src/mesFichiers/listeStagiaires.bin", "rw");
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
					filsGauche = LanceurBinaire.raf.readInt();
					filsDroit = LanceurBinaire.raf.readInt();
					
				
				System.out.println("Nom :" + nom.trim() + "\t Prenom :" + prenom.trim() + "\t Departement :"
						+ departement + "\t Promotion :" + promo.trim() + "\t Annee : " + annee);
			}
			

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	public static Noeud  lectureNoeud() throws IOException {

		Stagiaire stg = null ; 
		int filsGauche = -1;
		int filsDroit = -1;
		try {
			RandomAccessFile raf = new RandomAccessFile("src/mesFichiers/listeStagiaires.bin", "rw");			
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
				
		 stg = new Stagiaire(nom, prenom, departement, promo, annee)	; 
			
			raf.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		Noeud noeud = new Noeud(stg, filsGauche, filsDroit); 
		return noeud;

	}
}
