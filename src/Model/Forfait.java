package Model;

public class Forfait {

	private int id;
	private String nomForfait;
	private int cout;
	private int locationsMax;
	private int dureeMax;
	
	public Forfait(int id, String nomForfait, int cout, int locationsMax, int dureeMax) {
		this.setId(id);
		this.setNomForfait(nomForfait);
		this.setCout(cout);
		this.setLocationsMax(locationsMax);
		this.setDureeMax(dureeMax);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomForfait() {
		return nomForfait;
	}

	public void setNomForfait(String nomForfait) {
		this.nomForfait = nomForfait;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public int getLocationsMax() {
		return locationsMax;
	}

	public void setLocationsMax(int locationsMax) {
		this.locationsMax = locationsMax;
	}

	public int getDureeMax() {
		return dureeMax;
	}

	public void setDureeMax(int dureeMax) {
		this.dureeMax = dureeMax;
	}

}
