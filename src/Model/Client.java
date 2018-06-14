package Model;

import java.util.ArrayList;
import java.util.Date;

public class Client extends Utilisateur {

	private int idForfait;
	private ArrayList<Location> locationList;
	
	public Client(int id, String prenom, String nom, String courriel, String telephone, int idForfait, ArrayList<Adresse> adresseList, ArrayList<CarteCredit> carteCreditList, ArrayList<Location> locationList, Date dateNaissance, String motDePasse) {
		super(id, prenom, nom, courriel, telephone, adresseList, carteCreditList, dateNaissance, motDePasse);
		
		this.setIdForfait(idForfait);
		this.setLocationList(locationList);
	}

	public void addLocation(Location location) {
		this.locationList.add(location);
	}
	
	public int getIdForfait() {
		return idForfait;
	}

	public void setIdForfait(int idForfait) {
		this.idForfait = idForfait;
	}

	public ArrayList<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(ArrayList<Location> locationList) {
		this.locationList = locationList;
	}

}
