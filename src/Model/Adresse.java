package Model;

public class Adresse {
	
	private int noCivique;
	private String rue;
	private String ville;
	private String province;
	private String codePostal;

	public Adresse(int noCivique, String rue, String ville, String province, String codePostal) {
		this.setNoCivique(noCivique);
		this.setRue(rue);
		this.setVille(ville);
		this.setProvince(province);
		this.setCodePostal(codePostal);
	}

	public int getNoCivique() {
		return noCivique;
	}

	public void setNoCivique(int noCivique) {
		this.noCivique = noCivique;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

}
