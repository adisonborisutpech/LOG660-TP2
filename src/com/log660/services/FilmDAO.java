package com.log660.services;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import com.log660.beans.Film;
import com.log660.beans.Personnel;
import com.log660.utils.HibernateUtil;
import java.util.List;

public class FilmDAO {
	
	public static Film getFilmById(int filmGUID) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction trans = null;
		Film film = null;
		try {
			
			trans = session.beginTransaction();		
			film = (Film)session.createCriteria(Film.class).add(Restrictions.eq("guid", filmGUID)).uniqueResult();
	    	Hibernate.initialize(film.getGenres());
	    	Hibernate.initialize(film.getPersonnels());
	    	for(Personnel perso : film.getPersonnels()) {
		    	Hibernate.initialize(perso.getPersonne());
		    	Hibernate.initialize(perso.getRolepersonne());
	    	}
			System.out.println(film.getTitre());
			System.out.println(film.getPersonnels().iterator().next().getPersonne().getNom().toString());
			trans.commit();
			
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}	
		
		return film;
	}
	
	public static List<Film> getFilmByCriteria(String chaineNomFilm, Integer anneeMin, Integer anneeMax, // Min, Max -1 if nothing
            String[] nomPaysProduction, String[] languesOriginales, String[] genresFilm,
            String[] nomActeurs, String[] nomRealisateurs) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction trans = null;
		List<Film> films = null;
		try {
			
			trans = session.beginTransaction();		
			Criteria criteria = session.createCriteria(Film.class, "film");
			if (!chaineNomFilm.isEmpty()) {
				criteria.add(Restrictions.ilike("titre", chaineNomFilm, MatchMode.ANYWHERE));
			}

			if (anneeMin != -1 && anneeMax != -1) {
				criteria.add(Restrictions.between("anneesortie", anneeMin, anneeMax));
			}

			if (nomPaysProduction.length != 0) {
				for (String nomPays : nomPaysProduction) {
					criteria.add(Restrictions.ilike("paysproduction", nomPays, MatchMode.ANYWHERE));
				}
			}

			if (languesOriginales.length != 0) {
				for (String langue : languesOriginales) {
					criteria.add(Restrictions.ilike("langueoriginale", langue, MatchMode.ANYWHERE));
				}
			} 

			if (genresFilm.length != 0) {
				criteria.createAlias("film.genres", "genre");
				
				for (String genre : genresFilm) {
					criteria.add(Restrictions.ilike("genre.nom", genre, MatchMode.ANYWHERE));
				}
			} 

			criteria.createAlias("film.personnels", "personnels");
			criteria.createAlias("personnels.personne", "personne");
			if (nomRealisateurs.length != 0) {
				for (String realisateur : nomRealisateurs) {
					//System.out.println(realisateur);
					criteria.add(Restrictions.ilike("personne.nom", realisateur, MatchMode.ANYWHERE));
				}
			}
			
			if (nomActeurs.length != 0) {
				for (String acteur : nomActeurs) {
					//System.out.println(acteur);
					criteria.add(Restrictions.ilike("personne.nom", acteur, MatchMode.ANYWHERE));
				}
			}
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			films = criteria.list();
			//System.out.println(films.get(0).getTitre());
			System.out.println(films.size());
			for(Film film : films) {
				System.out.println(film.getTitre() + " - " + film.getGuid());
			}
			System.out.println();
			trans.commit();
			
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}	
		
		
		
		return films;
	}
}
