package com.log660.services;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.log660.beans.Film;
import com.log660.beans.Locationfilm;
import com.log660.beans.Utilisateur;
import com.log660.utils.HibernateUtil;

public class LocationDAO {
	
	// Retourne une liste de toutes les locations effectuées par un utilisateur
	public static List<Locationfilm> getLocationByUtilisateurId(int utilisateurGUID) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction trans = null;
		List<Locationfilm> locations = null;
		try {
			
			trans = session.beginTransaction();	
			locations = session.createCriteria(Locationfilm.class, "location").createAlias("location.utilisateur", "user").add(Restrictions.eq("user.guid", utilisateurGUID)).list();
			System.out.println(utilisateurGUID);
			trans.commit();
			
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}	
		System.out.println(locations.get(0).getUtilisateur().getNom());
		System.out.println(locations.size());
		return locations;
	}
	
	// Retourne une liste de toutes les locations effectuées pour un film
	public static List<Locationfilm> getLocationByFilmId(int filmGUID) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction trans = null;
		List<Locationfilm> locations = null;
		try {
			
			trans = session.beginTransaction();		
			locations = session.createCriteria(Locationfilm.class, "location").createAlias("location.film", "film").add(Restrictions.eq("film.guid", filmGUID)).list();
			System.out.println(filmGUID);
			trans.commit();
			
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}	
		
		return locations;
	}
	
	public static boolean createNewLocation(int utilisateurGUID, int filmGUID) {
		
		boolean success = false;
		
		Utilisateur utilisateur = UtilisateurDAO.getUtilisateurById(utilisateurGUID);
		Film film = FilmDAO.getFilmById(filmGUID);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction trans = null;

		try {
			
			Locationfilm location = new Locationfilm(film, utilisateur, new Date(), null);
			
			trans = session.beginTransaction();		
			session.save(location);
			trans.commit();
			
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}	
		
		return success;
	}
}
