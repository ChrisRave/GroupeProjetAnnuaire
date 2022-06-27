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
	
public  void importFichier(){
		

		try {
			FileReader fr = new FileReader("src/mesFichiers/STAGIAIRES_V2.DON");
			BufferedReader br = new BufferedReader(fr);
			
			
			while (br.ready()) {
				Stagiaire stagiaire = new Stagiaire(null, null,null,null,null);
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
	try {
		RandomAccessFile raf = new RandomAccessFile("src/mesFichiers/listeStagiaires.bin", "rw");
		if (raf.length() == 0) {
			this.racine = racineAjouter;
			this.racine.ecritureBinaire();
			raf.close();
		} else {
			raf.seek(0);
			// ajouter Noeud récursif
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}


	
////séparer dans nouvelle méthode 				
			}
//			else if (this.racine.getStagiaire().getNom().compareTo(noeudAAjouter.getStagiaire().getNom()) > 0) {
//				if (this.racine.getFilsGauche() == -1) {
//					
//					this.filsGauche()++; // taille d'un fichier divisé par la taille du noeud, variable static pour Noeud (taille stagiaire + taille fils gauche et fils droit), l'écriture sur le fils g et fils d se fait dans fichier bin
//					this.noeudAAjouter.ecritureBinaire();
//					this.noeudAAjouter.lectureBinaire();
//				} else {
//					this.filsGauche.ajouterNoeud(noeudAAjouter);
//				}
//			} else {
//				if (this.racine.getFilsDroit() == -1) {
//					
//					this.filsDroit++; 
//					this.noeudAAjouter.ecritureBinaire();
//					this.noeudAAjouter.lectureBinaire();
//				} else {
//					this.filsDroit.ajouterNoeud(noeudAAjouter);
//				}
//			}
//		}
//
//	}


}


