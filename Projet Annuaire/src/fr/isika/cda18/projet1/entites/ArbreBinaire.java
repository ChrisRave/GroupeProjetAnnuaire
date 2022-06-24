package fr.isika.cda18.projet1.entites;

public class ArbreBinaire extends LanceurRaf{
	
	public static void main(String[] args) {
		Stagiaire s1 = new Stagiaire("GHAZALA", "Houssam", "91", "ATOD 6", "2009");
		Stagiaire s2 = new Stagiaire("CHABAUD", "Julien", "75", "AI 91", "2014");
		Stagiaire s3 = new Stagiaire("MADELAIGUE", "Pascal", "92", "BOBI 3", "2007");
		Stagiaire s4 = new Stagiaire("DAVID", "Aur�lie", "75", "ATOD 2", "2008");
		Noeud monArbre = new Noeud(s1);
		monArbre.ajouterStagiaire(s2);
		monArbre.ajouterStagiaire(s3);
		monArbre.ajouterStagiaire(s4);
		
		System.out.println(monArbre);
	 
		
	}

}
