package fr.isika.cda18.projet1.entites;

public class Noeud {
	private Stagiaire stagiaire;
	private Noeud filsGauche;
	private Noeud filsDroit;

	public Noeud(Stagiaire stagiaire, Noeud filsGauche, Noeud filsDroit) {
		
		this.stagiaire= stagiaire;
		this.filsGauche = null;
		this.filsDroit = null;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public Noeud getFilsGauche() {
		return filsGauche;
	}

	public void setFilsGauche(Noeud filsGauche) {
		this.filsGauche = filsGauche;
	}

	public Noeud getFilsDroit() {
		return filsDroit;
	}

	public void setFilsDroit(Noeud filsDroit) {
		this.filsDroit = filsDroit;
	}

}
