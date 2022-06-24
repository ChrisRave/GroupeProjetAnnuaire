//package fr.isika.cda18.projet1.fichierTXT;
//
//import java.io.*;
//
//import fr.isika.cda18.projet1.entites.Stagiaire;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import fr.isika.cda18.projet1.entites.Stagiaire;
//
//class FichierTXT {
//	public static void main(String[] args) {
//
//		try {
//			File monFichier = new File("src/mesFichiers/STAGIAIRES.DON");
//			FileReader fr = new FileReader(monFichier);
//			BufferedReader br = new BufferedReader(fr);
//			String ligne = null;
//			
//			Stagiaire stagiaire = new Stagiaire(ligne, ligne, ligne, ligne, ligne);
//			while (br.ready()) {
//				stagiaire.setNom(br.readLine());
//				stagiaire.setPrenom(br.readLine());
//				stagiaire.setDepartement(br.readLine());
//				stagiaire.setPromotion(br.readLine());
//				stagiaire.setAnnee(br.readLine());
//				System.out.println(stagiaire);
//				
//				br.readLine();
//				
//				
//			}
//
//			br.close();
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//	}
//
//}
