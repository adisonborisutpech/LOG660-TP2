package com.log660.services;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import com.log660.beans.Film;
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
				criteria.add(Restrictions.like("titre", chaineNomFilm, MatchMode.ANYWHERE));
			}

			if (anneeMin != -1 && anneeMax != -1) {
				criteria.add(Restrictions.between("anneesortie", anneeMin, anneeMax));
			}

			if (nomPaysProduction.length != 0) {
				for (String nomPays : nomPaysProduction) {
					criteria.add(Restrictions.eq("paysproduction", nomPays));
				}
			}

			if (languesOriginales.length != 0) {
				for (String langue : languesOriginales) {
					criteria.add(Restrictions.eq("langueoriginale", langue));
				}
			} 

			if (genresFilm.length != 0) {
				criteria.createAlias("film.genres", "genre");
				
				for (String genre : genresFilm) {
					criteria.add(Restrictions.eq("genre.nom", genre));
				}
			} 

			criteria.createAlias("film.personnels", "personnels");
			criteria.createAlias("personnels.personne", "personne");
			if (nomRealisateurs.length != 0) {
				for (String realisateur : nomRealisateurs) {
					//System.out.println(realisateur);
					criteria.add(Restrictions.eq("personne.nom", realisateur));
				}
			}
			
			if (nomActeurs.length != 0) {
				for (String acteur : nomActeurs) {
					//System.out.println(acteur);
					criteria.add(Restrictions.eq("personne.nom", acteur));
				}
			}
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
