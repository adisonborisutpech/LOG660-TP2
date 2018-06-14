package Model;

import java.util.Date;

public class CarteCredit {

	private String marque;
	private int noCarte;
	private Date dateExpiration;
	private int CVV;
	
	public CarteCredit(String marque, int noCarte, Date dateExpiration, int CVV) {
		this.setMarque(marque);
		this.setNoCarte(noCarte);
		this.setDateExpiration(dateExpiration);
		this.setCVV(CVV);
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getNoCarte() {
		return noCarte;
	}

	public void setNoCarte(int noCarte) {
		this.noCarte = noCarte;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int CVV) {
		this.CVV = CVV;
	}

}
