//package fr.isika.cda18.projet1.entites;
//
//public class Noeud {
//	private Stagiaire stagiaire;
//	private Noeud filsGauche;
//	private Noeud filsDroit;
//
//	public Noeud(Stagiaire stagiaire, Noeud filsGauche, Noeud filsDroit) {
//		
//		this.stagiaire= stagiaire;
//		this.filsGauche = null;
//		this.filsDroit = null;
//	}
//
//	public Stagiaire getStagiaire() {
//		return stagiaire;
//	}
//
//	public void setStagiaire(Stagiaire stagiaire) {
//		this.stagiaire = stagiaire;
//	}
//
//	public Noeud getFilsGauche() {
//		return filsGauche;
//	}
//
//	public void setFilsGauche(Noeud filsGauche) {
//		this.filsGauche = filsGauche;
//	}
//
//	public Noeud getFilsDroit() {
//		return filsDroit;
//	}
//
//	public void setFilsDroit(Noeud filsDroit) {
//		this.filsDroit = filsDroit;
//	}
//	// m�thodes sp�cifiques
//
//		public String toString() {
//			String result = "";
//			if (this.filsGauche != null) {
//				result += this.filsGauche.toString();
//			}
//			result += " " + stagiaire;
//			if (this.filsDroit != null) {
//				result += this.filsDroit.toString();
//			}
//
//			return result;
//		}
//
//		public void ajouterValeur(Stagiaire stagiaireAAjouter) {
//			if (this.stagiaire.compareTo(stagiaireAAjouter) > 0) {
//				if (this.filsGauche == null) {
//					this.filsGauche = new Stagiaire();
//				} else {
//					this.filsGauche.ajouterValeur(stagiaireAAjouter);
//				}
//			} else {
//				if (this.filsDroit == null) {
//					this.filsDroit = new Stagiaire);
//				} else {
//					this.filsDroit.ajouterValeur(stagiaireAAjouter);
//				}
//			}
//		}
//
//}
