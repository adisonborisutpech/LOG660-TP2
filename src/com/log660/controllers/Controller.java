package com.log660.controllers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;

import com.log660.beans.Utilisateur;
import com.log660.beans.Locationfilm;
import com.log660.beans.Personne;
import com.log660.beans.Personnel;
import com.log660.beans.Film;
import com.log660.beans.Genre;
import com.log660.services.UtilisateurDAO;
import com.log660.services.FilmDAO;
import com.log660.services.LocationDAO;
import com.log660.services.PersonneDAO;
import com.log660.ui.Window;

public class Controller {

    private static Window w;
    private static String login;

    public static void main (String[] args) {
        w = new Window();
    }

    public static Window getWindowInstance() {
        return w;
    }

    public static boolean attemptLogin (String loginName, String password) {
        //appel a la BD pour verifier credentials
    	boolean success = false;

    	Utilisateur utilisateur = UtilisateurDAO.getUtilisateurByEmail(loginName);
        //Hibernate doit retourner un boolean si ca a marche ou non, et si non un message d'erreur aussi

        //si le login a marche
    	if (utilisateur.getMotdepasse().equals(password)) {
    		login = loginName;
    		success = true;
    		System.out.println("Login successful...");
    	} else {
    		System.out.println("Login not successful...");
    	}

        return success;
    }


    public static ArrayList<ArrayList<String>> searchMovie (String chaineNomFilm, int anneeMin, int anneeMax,
                                       String[] nomPaysProduction, String[] langueOriginale, String[] genreFilm,
                                       String[] nomActeur, String[] nomRealisateur) {
    	ArrayList<ArrayList<String>> result = new ArrayList();
    	List<Film> listeFilms = FilmDAO.getFilmByCriteria(chaineNomFilm, anneeMin, anneeMax, nomPaysProduction, langueOriginale, genreFilm, nomActeur, nomRealisateur);
    	for(Film film : listeFilms) {
    		ArrayList<String> infosFilm = new ArrayList();
    		infosFilm.add(film.getTitre());
    		infosFilm.add(Integer.toString(film.getGuid()));
    		result.add(infosFilm);
    	}
    	
        return result;

    }

    public static boolean locationFilm (int filmGUID, String loginName) {
        //appel a la BD pour verifier que le  forfait permet la location et qu<un film est disponible
    	
    	Utilisateur user = UtilisateurDAO.getUtilisateurByEmail(loginName);
    	
    	boolean success = LocationDAO.createNewLocation(user.getGuid(), filmGUID);
    	
        //si oui, retourner true, si non false
        return success;
    }

    // TODO : Degeux, a refaire
    public static ArrayList<ArrayList<String>> getFilmById (int filmGUID) {
    	ArrayList<ArrayList<String>> results = new ArrayList();
    	ArrayList<String> temp = new ArrayList();
    	Film film = FilmDAO.getFilmById(filmGUID);
    	
    	temp.add(film.getTitre());//0
    	results.add(temp);
    	temp = new ArrayList();
    	temp.add(film.getAnneesortie().toString());//1
    	results.add(temp);
    	temp = new ArrayList();
    	temp.add(film.getPaysproduction());//2
    	results.add(temp);
    	temp = new ArrayList();
    	temp.add(film.getLangueoriginale());//3
    	results.add(temp);
    	temp = new ArrayList();
    	temp.add(film.getDureefilm().toString());//4
    	results.add(temp);
    	temp = new ArrayList();
    	try {
			temp.add(film.getResumescenario().getSubString(1, (int) film.getResumescenario().length()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//5
    	results.add(temp);
    	temp = new ArrayList();
    	temp.add(film.getQuantite().toString());//6
    	results.add(temp);
    	temp = new ArrayList();
    	
    	for(Genre genre : film.getGenres()) {//7
        	temp.add(genre.getNom());
    	}
    	results.add(temp);

    	temp = new ArrayList();
    	for(Personnel perso : film.getPersonnels()) {
    		if(perso.getRolepersonne().getNom().equals("Directeur")) {//8
            	temp.add(perso.getPersonne().getNom());
            	temp.add(perso.getPersonne().getBiographie().toString());
    		}
    	}
    	results.add(temp);
    	
    	temp = new ArrayList();
    	for(Personnel perso : film.getPersonnels()) {
    		if(perso.getRolepersonne().getNom().equals("Scenariste")) {//9
            	temp.add(perso.getPersonne().getNom());
    		}
    	}
    	results.add(temp);
    	
    	temp = new ArrayList();
    	for(Personnel perso : film.getPersonnels()) {
    		if(!perso.getRolepersonne().getNom().equals("Directeur") && !perso.getRolepersonne().getNom().equals("Scenariste")) {//10
            	temp.add(perso.getPersonne().getNom() + "," + perso.getPersonne().getGuid());
    		}
    	}
    	results.add(temp);
    	
    	temp = new ArrayList();
    	temp.add(Integer.toString(film.getGuid()));//11
    	results.add(temp);
    	
    	return results;
    }

    public static Personne getPersonneById (int personneID) {
    	Personne personne = PersonneDAO.getPersonneById(personneID);
        return personne;
    }
}
