package fr.isika.cda18.projet1.fichierTXT;

import java.io.*;

class FichierTxt {
	public static void main(String[] args) {

		try {
			File monFichier = new File("C:\\Users\\ravel\\OneDrive\\Documents\\CDA 18\\W7\\D3\\Docs\\STAGIAIRES.DON");
			FileReader fr = new FileReader(monFichier);
			BufferedReader br = new BufferedReader(fr);
			String ligne = null;
			while ((ligne = br.readLine()) != null) {
				System.out.println(ligne);
			}

			br.close();
			String[] liste = ligne.split("*");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
