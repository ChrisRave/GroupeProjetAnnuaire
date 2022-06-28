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

	public void ajouterRacine(Noeud noeud) throws IOException {
	
		
		if (LanceurBinaire.raf.length() == 0) {
			Noeud.ecritureBinaire(noeud);
		} else {
			LanceurBinaire.raf.seek(0);
			this.ajouterStagiaire(noeud); 
		}
		
}
	
	public void ajouterStagiaire(Noeud stagiaireAjouter) throws IOException {
		
		Noeud racine = Noeud.lectureNoeud(); 
		
		if (racine.getStagiaire().getNom().compareTo(stagiaireAjouter.getStagiaire().getNom()) > 0) {

			if (racine.getFilsGauche() == -1) {
				LanceurBinaire.raf.seek(LanceurBinaire.raf.getFilePointer() - 8);
				LanceurBinaire.raf.writeInt((int) (LanceurBinaire.raf.length() / Stagiaire.TAILLE_OBJET_OCTET));
				LanceurBinaire.raf.seek(LanceurBinaire.raf.length());
				Noeud.ecritureBinaire(stagiaireAjouter ); 
			} else {
				LanceurBinaire.raf.seek(racine.getFilsGauche()*Stagiaire.TAILLE_OBJET_OCTET);
				this.ajouterStagiaire(stagiaireAjouter);
			}

		} else {
			if (racine.getFilsDroit() == -1) {
				LanceurBinaire.raf.seek(LanceurBinaire.raf.getFilePointer() - 4);
				LanceurBinaire.raf.writeInt((int) (	LanceurBinaire.raf.length() / Stagiaire.TAILLE_OBJET_OCTET));
				LanceurBinaire.raf.seek(	LanceurBinaire.raf.length());
				Noeud.ecritureBinaire(stagiaireAjouter ); 
			} else {
				LanceurBinaire.raf.seek(racine.getFilsDroit()*Stagiaire.TAILLE_OBJET_OCTET);
				this.ajouterStagiaire(stagiaireAjouter);
			
			}
		}

	}

}
