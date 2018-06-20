package com.log660.services;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.log660.beans.Locationfilm;
import com.log660.utils.HibernateUtil;

public class LocationDAO {
	
	public static List<Locationfilm> getLocationByPersonneId(int personneGUID) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction trans = null;
		List<Locationfilm> locations = null;
		try {
			
			trans = session.beginTransaction();		
			locations = (List<Locationfilm>)session.createCriteria(Locationfilm.class).add(Restrictions.eq("noUtilisateur", personneGUID));
			System.out.println(personneGUID);
			trans.commit();
			
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}	
		
		return locations;
	}
	
	public static List<Locationfilm> getLocationByFilmId(int filmGUID) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction trans = null;
		List<Locationfilm> locations = null;
		try {
			
			trans = session.beginTransaction();		
			locations = (List<Locationfilm>)session.createCriteria(Locationfilm.class).add(Restrictions.eq("noFilm", filmGUID));
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
}
