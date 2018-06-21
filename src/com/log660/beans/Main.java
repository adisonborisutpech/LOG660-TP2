package com.log660.beans;

import com.log660.controllers.Controller;
import com.log660.services.FilmDAO;
import com.log660.services.LocationDAO;
import com.log660.services.PersonneDAO;
import com.log660.services.UtilisateurDAO;

public class Main {
	public static void main(String[] args) {
		//UtilisateurDAO.getUtilisateurByEmail("PeterFBorja24@hotmail.com");
		//PersonneDAO.getPersonneById(833865);
		String[] test = {};
		String[] test1 = {};
		String[] test4 = {};
		String[] test2 = {};
		String[] test3 = {};
		//FilmDAO.getFilmByCriteria("", 1997, 1997, test, test4, test1, test2, test3);
		Controller.searchMovie("", 1997, 1997, test, test4, test1, test2, test3);
		//LocationDAO.getLocationByUtilisateurId(441887);
	}
}
