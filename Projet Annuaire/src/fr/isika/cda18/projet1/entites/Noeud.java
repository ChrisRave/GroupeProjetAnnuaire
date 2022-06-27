package fr.isika.cda18.projet1.entites;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Noeud{
	private Stagiaire stagiaire;
	private int filsGauche;
	private int filsDroit;
//taille d'un noeud = stagiaire + 2 entiers
	
	
	//Constructeur
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

	//Méthodes spécifiques
	public void ecritureBinaire() throws IOException {

		try {
			RandomAccessFile raf = new RandomAccessFile("src/mesFichiers/listStagiaiares.bin", "rw");
			raf.writeChars(this.stagiaire.agrandirNom());
			raf.writeChars(this.stagiaire.agrandirPrenom());
			raf.writeChars(this.stagiaire.getDepartement());
			raf.writeChars(this.stagiaire.agrandirPromo());
			raf.writeChars(this.stagiaire.getAnnee());
			raf.writeInt(filsDroit); 
			raf.writeInt(filsGauche); 
			raf.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
	}

	public void lectureBinaire() throws IOException {

		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile("src/mesFichiers/listStagiaiares.bin", "rw");
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
//rajouter fils gauche et fils droit
				System.out.println("Nom :" + nom.trim() + "\t Prenom :" + prenom.trim() + "\t Departement :"
						+ departement + "\t Promotion :" + promo.trim() + "\t Annee : " + annee);
			}
			raf.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}	
	

}
