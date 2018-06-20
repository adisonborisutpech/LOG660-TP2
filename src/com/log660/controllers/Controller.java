package com.log660.controllers;
import java.util.List;

import com.log660.beans.Utilisateur;
import com.log660.beans.Locationfilm;
import com.log660.beans.Personne;
import com.log660.beans.Film;
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


    public static List<Object> searchMovie (String chaineNomFilm, int anneeMin, int anneeMax,
                                       String[] nomPaysProduction, String[] langueOriginale, String[] genreFilm,
                                       String[] nomActeur, String[] nomRealisateur) {
        //appel a la BD pour recherche de films

        /*doit retourner tous les films qui matchent, avec ces infos :
        • Le titre du film ;
        • L’annee de sortie du film ; ´
        • Le nom de tous les pays de production ;
        • La langue originale du film ;
        • La duree du film (en minutes) ; ´
        • La liste de tous les genres du film ;
        • Le nom du realisateur ; ´
        • Le nom de tous les scenaristes ; ´
        • Le nom de tous les acteurs et de leur(s) personnage(s) dans le film ;
        • Le resume du scenario du film
        */
        //ces infos seront utilsees pour creer des objets film


        //ce serait aussi utile de donner le nombre de films en stock
    	
    	List<Object> listeFilms = FilmDAO.getFilmByCriteria(chaineNomFilm, anneeMin, anneeMax, nomPaysProduction, langueOriginale, genreFilm, nomActeur, nomRealisateur);

        return listeFilms;

    }

    public static boolean locationFilm (int filmGUID, String loginName) {
        //appel a la BD pour verifier que le  forfait permet la location et qu<un film est disponible
    	
    	Utilisateur user = UtilisateurDAO.getUtilisateurByEmail(loginName);
    	
    	boolean success = LocationDAO.createNewLocation(user.getGuid(), filmGUID);
    	
        //si oui, retourner true, si non false
        return success;
    }



}
