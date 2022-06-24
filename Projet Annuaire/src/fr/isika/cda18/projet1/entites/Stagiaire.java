
package fr.isika.cda18.projet1.entites;

public class Stagiaire {
	public static final int TAILLE_NOM = 42;
	public static final int TAILLE_PRENOM = 40;
	public static final int TAILLE_PROMO = 22;
	public static final int TAILLE_DEPARTEMENT = 2;
	public static final int TAILLE_ANNEE = 4;
	public static final int TAILLE_OBJET_OCTET = 112;

	String nom;
	String prenom;
	String departement;
	String promotion;
	String annee;


	public Stagiaire(String nom, String prenom, String departement , String promotion, String annee) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement ;
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
		return "Nom : " + nom + "\t  Prenom : " + prenom + "\t Departement=" + departement + "\t Promotion : "
				+ promotion + "\t Annee : " + annee;
	}

	public String agrandirNom() {
		String nomLong = this.nom;
		for (int i = nom.length(); i < TAILLE_NOM; i++) {
			nomLong += " ";
		}
		return nomLong;
	}

	public String agrandirPrenom() {
		String prenomLong = this.prenom;
		for (int i = prenom.length(); i < TAILLE_PRENOM; i++) {
			prenomLong += " ";
		}
		return prenomLong;
	}

	public String agrandirPromo() {
		String promoLong = this.promotion;
		for (int i = promotion.length(); i < TAILLE_PROMO; i++) {
			promoLong += " ";
		}
		return promoLong;
	}

}