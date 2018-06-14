package Model;

import java.util.ArrayList;

public class Film {

	private int id;
	private String titre;
	private int anneeSortie;
	private String paysProduction;
	private String langueOriginale;
	private int dureeFilm;
	private String genre;
	private int realisateurId;
	private ArrayList<Integer> scenaristeIdList;
	private ArrayList<Integer> acteurIdList;
	private ArrayList<String> roleList;
	private String resume;
	private int quantite;
	
	public Film(int id, String titre, int anneeSortie, String paysProduction, String langueOriginale, int dureeFilm, String genre, int realisateurId, 
			ArrayList<Integer> scenaristeIdList, ArrayList<Integer> acteurIdList, ArrayList<String> roleList, String resume, int quantite) {
		
		this.setId(id);
		this.setTitre(titre);
		this.setAnneeSortie(anneeSortie);
		this.setPaysProduction(paysProduction);
		this.setLangueOriginale(langueOriginale);
		this.setDureeFilm(dureeFilm);
		this.setGenre(genre);
		this.setRealisateurId(realisateurId);
		this.setScenaristeIdList(scenaristeIdList);
		this.setActeurIdList(acteurIdList);
		this.setRoleList(roleList);
		this.setResume(resume);
		this.setQuantite(quantite);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnneeSortie() {
		return anneeSortie;
	}

	public void setAnneeSortie(int anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	public String getPaysProduction() {
		return paysProduction;
	}

	public void setPaysProduction(String paysProduction) {
		this.paysProduction = paysProduction;
	}

	public String getLangueOriginale() {
		return langueOriginale;
	}

	public void setLangueOriginale(String langueOriginale) {
		this.langueOriginale = langueOriginale;
	}

	public int getDureeFilm() {
		return dureeFilm;
	}

	public void setDureeFilm(int dureeFilm) {
		this.dureeFilm = dureeFilm;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRealisateurId() {
		return realisateurId;
	}

	public void setRealisateurId(int realisateurId) {
		this.realisateurId = realisateurId;
	}

	public ArrayList<Integer> getScenaristeIdList() {
		return scenaristeIdList;
	}

	public void setScenaristeIdList(ArrayList<Integer> scenaristeIdList) {
		this.scenaristeIdList = scenaristeIdList;
	}

	public ArrayList<Integer> getActeurIdList() {
		return acteurIdList;
	}

	public void setActeurIdList(ArrayList<Integer> acteurIdList) {
		this.acteurIdList = acteurIdList;
	}

	public ArrayList<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(ArrayList<String> roleList) {
		this.roleList = roleList;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
