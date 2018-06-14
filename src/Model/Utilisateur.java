package Model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Utilisateur extends Personne {

	private int id;
	private String courriel;
	private String telephone;
	private ArrayList<Adresse> adresseList;
	private ArrayList<CarteCredit> carteCreditList;
	private Date dateNaissance;
	private String motDePasse;
	
	public Utilisateur(int id, String prenom, String nom, String courriel, String telephone, ArrayList<Adresse> adresseList, ArrayList<CarteCredit> carteCreditList, Date dateNaissance, String motDePasse) {

		this.setId(id);
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setCourriel(courriel);
		this.setTelephone(telephone);
		this.setAdresseList(adresseList);
		this.setCarteCreditList(carteCreditList);
		this.setDateNaissance(dateNaissance);
		this.setMotDePasse(motDePasse);
		
	}
	
	public void addAdresse(Adresse adresse) {
		this.adresseList.add(adresse);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public ArrayList<Adresse> getAdresseList() {
		return adresseList;
	}

	public void setAdresseList(ArrayList<Adresse> adresseList) {
		this.adresseList = adresseList;
	}

	public ArrayList<CarteCredit> getCarteCreditList() {
		return carteCreditList;
	}

	public void setCarteCreditList(ArrayList<CarteCredit> carteCreditList) {
		this.carteCreditList = carteCreditList;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
