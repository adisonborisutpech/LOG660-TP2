package com.log660.beans;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.log660.utils.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			
			trans = session.beginTransaction();
			Genre genre = new Genre();
			genre.setNom("Alternatives");
			
			session.save(genre);
			trans.commit();
			
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
