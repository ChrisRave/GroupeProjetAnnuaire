package fr.isika.cda18.projet1.entites;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class ArbreBinaire {

	static List<Stagiaire> stagiaires = new ArrayList<>();

	Noeud racine;

	public void importFichier() {

		try {
			FileReader fr = new FileReader("src/mesFichiers/STAGIAIRES_V2.DON");
			BufferedReader br = new BufferedReader(fr);

			while (br.ready()) {
				Stagiaire stagiaire = new Stagiaire(null, null, null, null, null);
				stagiaire.setNom(br.readLine());
				stagiaire.setPrenom(br.readLine());
				stagiaire.setDepartement(br.readLine());
				stagiaire.setPromotion(br.readLine());
				stagiaire.setAnnee(br.readLine());
				br.readLine();
				stagiaires.add(stagiaire);

			}
			System.out.println(stagiaires);
			br.close();
			fr.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void ajouterRacine(Noeud racineAjouter) throws IOException {
		
		RandomAccessFile raf ; 
		
			if (LanceurBinaire.raf.length() == 0) {
				this.racine = racineAjouter;
				this.racine.ecritureBinaire();
				LanceurBinaire.raf.close();
			} else {
				LanceurBinaire.raf.seek(0);
				this.ajouterStagiaire(new Noeud(null, -1, -1));
			}

	}
	public void ajouterStagiaire(Noeud stagiaireAjouter) throws IOException {

		RandomAccessFile raf;

		if (this.racine.getStagiaire().getNom().compareTo(stagiaireAjouter.getStagiaire().getNom()) > 0) {

			if (this.racine.getFilsGauche() == -1) {
				LanceurBinaire.raf.seek(raf.getFilePointer() - 8);
				LanceurBinaire.raf.writeInt((int) (raf.length() / Stagiaire.TAILLE_OBJET_OCTET));
				LanceurBinaire.raf.seek(raf.length());
				this.ajouterStagiaire(stagiaireAjouter);
			} else {
				this.racine.getFilsGauche().ajouterStagiaire(stagiaireAjouter);
			}

		} else {
			if (this.racine.getFilsDroit() == -1) {
				LanceurBinaire.raf.seek(raf.getFilePointer() - 4);
				LanceurBinaire.raf.writeInt((int) (raf.length() / Stagiaire.TAILLE_OBJET_OCTET));
				LanceurBinaire.raf.seek(raf.length());
				LanceurBinaire.raf.stagiaireAjouter.ecritureBinaire();
			} else {
				this.racine.getFilsDroit().ajouterStagiaire(stagiaireAjouter);
			}
		}

	}

}
