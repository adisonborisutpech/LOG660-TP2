package com.log660.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.log660.beans.Personne;
import com.log660.beans.Utilisateur;
import com.log660.utils.HibernateUtil;

public class PersonneDAO {

	public static Personne getPersonneById(int personneGUID) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction trans = null;
		Personne personne = null;
		try {
			
			trans = session.beginTransaction();		
			personne = (Personne)session.createCriteria(Personne.class).add(Restrictions.eq("guid", personneGUID)).uniqueResult();
			System.out.println(personne.getNom());
			trans.commit();
			
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}	
		
		return personne;
	}
}
