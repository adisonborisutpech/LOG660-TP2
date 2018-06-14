package Model;

import java.util.Date;

public class Scenariste extends Personne {

	private int id;
	private Date dateNaissance;
	private String lieuNaissance;
	private String biography;
	
	public Scenariste(int id, String prenom, String nom, Date dateNaissance, String lieuNaissance, String biography) {
		this.setId(id);
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setDateNaissance(dateNaissance);
		this.setLieuNaissance(lieuNaissance);
		this.setBiography(biography);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

}
