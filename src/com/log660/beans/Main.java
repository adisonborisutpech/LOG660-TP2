package com.log660.beans;

import com.log660.services.FilmDAO;
import com.log660.services.PersonneDAO;
import com.log660.services.UtilisateurDAO;

public class Main {
	public static void main(String[] args) {
		//UtilisateurDAO.getUtilisateurByEmail("PeterFBorja24@hotmail.com");
		//PersonneDAO.getPersonneById(833865);
		String[] test = {"USA"};
		String[] test1 = {"Family"};
		String[] test2 = {};
		String[] test3 = {"Leslie Mann"};
		FilmDAO.getFilmByCriteria("", 1997, 1997, test, "", test1, test2, test3);
	}
}
