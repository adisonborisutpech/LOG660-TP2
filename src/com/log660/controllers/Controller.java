package com.log660.controllers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    private static String username;

    public static void main (String[] args) {
        w = new Window();
    }

    public static Window getWindowInstance() {
        return w;
    }
    
    public static boolean attemptLogin (String email, String password) {
        //appel a la BD pour verifier credentiales
    	boolean success = false;

    	Utilisateur utilisateur = UtilisateurDAO.getUtilisateurByEmail(email);
    	//Si l'utilisateur n'exista pas
    	if(!( utilisateur instanceof Utilisateur)) {
    		JOptionPane.showMessageDialog(new JFrame(), "courriel non valide", "Dialog", 
    				JOptionPane.ERROR_MESSAGE);
    	}

        //si le login a marche
    	if (utilisateur.getMotdepasse().equals(password)) {
    		username = email;
    		success = true;
    		System.out.println("Login successful...");
    	} else {
    		System.out.println("Login not successful...");
			//Si bon courriel mais mauvais mot de passe;
    		JOptionPane.showMessageDialog(new JFrame(), "mot de passe non valide", "Dialog", 
    				JOptionPane.ERROR_MESSAGE);
    	}

        return success;
    }


    public static ArrayList<ArrayList<String>> searchMovie (String chaineNomFilm, int anneeMin, int anneeMax,
                                       String[] nomPaysProduction, String[] langueOriginale, String[] genreFilm,
                                       String[] nomActeur, String[] nomRealisateur) {
    	
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    	
    	List<Film> listeFilms = FilmDAO.getFilmByCriteria(chaineNomFilm, anneeMin, anneeMax, nomPaysProduction, langueOriginale, 
    			genreFilm, nomActeur, nomRealisateur);
    	
    	for(Film film : listeFilms) {
    		ArrayList<String> infosFilm = new ArrayList<String>();
    		infosFilm.add(film.getTitre());
    		infosFilm.add(Integer.toString(film.getGuid()));
    		result.add(infosFilm);
    	}
    	
        return result;

    }

    public static boolean locationFilm (int filmGUID) {
        //appel a la BD pour verifier que le  forfait permet la location et qu<un film est disponible
    	
    	Utilisateur user = UtilisateurDAO.getUtilisateurByEmail(username);
    	
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

    public static ArrayList<String> getPersonneById (int personneID) {
    	ArrayList<String> results = new ArrayList();
    	Personne personne = PersonneDAO.getPersonneById(personneID);
    	
    	results.add(personne.getNom());
    	if(personne.getDatenaissance() != null) {
        	results.add(personne.getDatenaissance().toString());
    	}
    	else {
    		results.add("");
    	}
    	if(personne.getLieunaissance() != null) {
        	results.add(personne.getLieunaissance());
    	}
    	else {
    		results.add("");
    	}
    	try {
        	if(personne.getBiographie() != null) {
        		results.add(personne.getBiographie().getSubString(1, (int) personne.getBiographie().length()));
        	}
        	else {
        		results.add("");
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//5
    	
        return results;
    }
}
