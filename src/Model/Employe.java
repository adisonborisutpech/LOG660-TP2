package Model;

import java.util.ArrayList;
import java.util.Date;

public class Employe extends Utilisateur {

	private int matricule;
	
	public Employe(int id, String prenom, String nom, int matricule, String courriel, String telephone, ArrayList<Adresse> adresseList, ArrayList<CarteCredit> carteCreditList, Date dateNaissance, String motDePasse) {
		super(id, prenom, nom, courriel, telephone, adresseList, carteCreditList, dateNaissance, motDePasse);
		this.setMatricule(matricule);
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

}
