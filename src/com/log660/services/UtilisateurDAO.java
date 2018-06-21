package com.log660.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.log660.beans.Utilisateur;
import com.log660.utils.HibernateUtil;

import sun.rmi.runtime.Log;

public class UtilisateurDAO {
	
	public static Utilisateur getUtilisateurById(int utilisateurGUID) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		/*CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteria = builder.createQuery(Utilisateur.class);
        Root<Utilisateur> utilsateurRoot = criteria.from(Utilisateur.class);
        criteria.select(utilsateurRoot); 
        criteria.where(builder.equal(utilsateurRoot.get("courriel"), email));*/
		
		Transaction trans = null;
		Utilisateur utilisateur = null;
		try {
			
			trans = session.beginTransaction();		
			utilisateur = (Utilisateur)session.createCriteria(Utilisateur.class).add(Restrictions.eq("guid", utilisateurGUID)).uniqueResult();			
			trans.commit();
			
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}	
		
		return utilisateur;
	}
	
	public static Utilisateur getUtilisateurByEmail(String email) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction trans = null;
		Utilisateur utilisateur = null;
		try {
			
			trans = session.beginTransaction();		
			utilisateur = (Utilisateur)session.createCriteria(Utilisateur.class).add(Restrictions.eq("courriel", email)).uniqueResult();			
			trans.commit();
			
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
			System.out.println("Not user associated with this email");
		} finally {
			session.close();
		}	
		
		return utilisateur;
	}
}
