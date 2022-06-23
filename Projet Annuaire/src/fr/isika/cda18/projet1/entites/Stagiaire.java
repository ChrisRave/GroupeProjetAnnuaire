package fr.isika.cda18.projet1.entites;

public class Stagiaire {

	
	String nom; 
	String prenom; 
	String departement; 
	String promotion; 
	String annee;
	
	
	public Stagiaire(String nom, String prenom, String departement, String promotion, String annee) {
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
		this.promotion = promotion;
		this.annee = annee;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getDepartement() {
		return departement;
	}


	public void setDepartement(String departement) {
		this.departement = departement;
	}


	public String getPromotion() {
		return promotion;
	}


	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}


	public String getAnnee() {
		return annee;
	}


	public void setAnnee(String annee) {
		this.annee = annee;
	}


	@Override
	public String toString() {
		return "Nom: " + nom + "\t Prenom: " + prenom + "\t Departement: " + departement + "\t Promotion: "
				+ promotion + "\t Annee: " + annee ;
	} 
	
   
	
	
}
