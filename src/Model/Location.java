package Model;

import java.util.Date;

public class Location {

	private int id;
	private Date dateLocation;
	private Date dateRetour;
	private int idFilm;
	
	public Location(int id, Date dateLocation, int idFilm) {
		this.setId(id);
		this.setDateLocation(dateLocation);
		this.setIdFilm(idFilm);
	}
	
	public Location(int id, Date dateLocation, Date dateRetour, int idFilm) {
		this.setId(id);
		this.setDateLocation(dateLocation);
		this.setDateRetour(dateRetour);
		this.setIdFilm(idFilm);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateLocation() {
		return dateLocation;
	}

	public void setDateLocation(Date dateLocation) {
		this.dateLocation = dateLocation;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public int getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

}
