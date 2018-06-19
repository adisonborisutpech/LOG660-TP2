package com.log660.beans;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.log660.services.UtilisateurDAO;
import com.log660.utils.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		UtilisateurDAO.getUtilisateurByEmail("PeterFBorja24@hotmail.com");
	}
}
