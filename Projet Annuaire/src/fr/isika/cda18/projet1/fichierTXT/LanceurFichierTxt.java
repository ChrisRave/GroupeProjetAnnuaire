package fr.isika.cda18.projet1.fichierTXT;

import java.io.*;

import fr.isika.cda18.projet1.entites.Stagiaire;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fr.isika.cda18.projet1.entites.Stagiaire;

class FichierTXT {
	public static void main(String[] args) {
		
		List<Stagiaire> stagiaires = new ArrayList<>();

		try {
			FileReader fr = new FileReader("src/mesFichiers/STAGIAIRES_V2.DON");
			BufferedReader br = new BufferedReader(fr);
			
			Stagiaire stagiaire = new Stagiaire(null, null,null,null,null);
			while (br.ready()) {
				stagiaire.setNom(br.readLine());
				stagiaire.setPrenom(br.readLine());
				stagiaire.setDepartement(br.readLine());
				stagiaire.setPromotion(br.readLine());
				stagiaire.setAnnee(br.readLine());
				br.readLine();
			
				stagiaires.add(stagiaire); 
				
			}

			br.close();
			fr.close(); 

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}