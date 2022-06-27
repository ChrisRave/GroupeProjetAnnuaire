package fr.isika.cda18.projet1.entites;

import java.io.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class LanceurFichierTxt {
	
	
	static List<Stagiaire> stagiaires = new ArrayList<>();
	
	public static void main(String[] args) {
		
		

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
				System.out.println(stagiaires);

			}

			br.close();
			fr.close(); 

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	
	}

}