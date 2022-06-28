package fr.isika.cda18.projet1.entites;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LanceurBinaire {

	public static RandomAccessFile raf;

	public static void main(String[] args) throws IOException {

		raf = new RandomAccessFile("src/mesFichiers/listeStagiaires.bin", "rw");
		raf.setLength(0);
		ArbreBinaire arbre = new ArbreBinaire();
		arbre.importFichier();

		for (int i = 0; i < ArbreBinaire.stagiaires.size(); i++) {
			arbre.ajouterRacine(new Noeud(ArbreBinaire.stagiaires.get(i), -1, -1));

		}
		Noeud.lectureBinaire();
		arbre.affichageInfixe();
		raf.close();

	}

}
