package com.log660.services;

import java.sql.*;

import com.log660.beans.Film;
import com.log660.beans.Utilisateur;

public class ServicesETL {
	
	private Connection ctn;
	
	public ServicesETL() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			 
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
	}
	
	public void executeLinkDBETL() {
		try {
			ctn = DriverManager.getConnection("jdbc:oracle:thin:@log660ora12c.logti.etsmtl.ca:1521:LOG660","equipe11","HLxL95Md");
			Statement stmt = ctn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM LOG6601C.COTES@LINK_LOG660_EQ05"); 
			
			while(result.next()) {
				//insert in Transaction table
				
			}
			
			stmt.close();
			result.close();
			ctn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void executeFilmETL() {
		try {
			ctn = DriverManager.getConnection("jdbc:oracle:thin:@log660ora12c.logti.etsmtl.ca:1521:LOG660","equipe11","HLxL95Md");
			Statement stmt = ctn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM FILM"); 
			
			while(result.next()) {
				// Récupérer les genres
				Statement subStmt = ctn.createStatement();
				ResultSet subResult = subStmt.executeQuery("SELECT G.NOM FROM GENRE G, FILMGENRE FG WHERE G.GUID = FG.NOGENRE AND FG.NOFILM =" + result.getInt(1));
				while(subResult.next()) {
					System.out.println(subResult.getString(1));
					//Switchcase Genres
				}
				subResult.close();
				subStmt.close();
				
			}
			
			stmt.close();
			result.close();
			ctn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}		
	}
	
	public void executeUtilisateurETL() {
		try {
			ctn = DriverManager.getConnection("jdbc:oracle:thin:@log660ora12c.logti.etsmtl.ca:1521:LOG660","equipe11","HLxL95Md");
			Statement stmt = ctn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM UTILISATEUR"); 
			
			while(result.next()) {
				String nom = result.getString(5) + " " + result.getString(6); 
				System.out.println(nom);
				
				// Récupérer les données de l'adresse
				Statement subStmt = ctn.createStatement();
				ResultSet subResult = subStmt.executeQuery("SELECT A.VILLE, A.PROVINCE, A.CODEPOSTAL FROM ADRESSE A WHERE A.GUID = " + result.getInt(2));
				if(subResult.next()) {
					System.out.println(subResult.getString(1));
				}
				subResult.close();
				subStmt.close();
				
				// Récupérer l'ancienneté
				subStmt = ctn.createStatement();
				ResultSet ancienneteResult = subStmt.executeQuery("SELECT L.DATELOCATIONFILM FROM LOCATIONFILM L WHERE L.NOUTILISATEUR = " + result.getInt(1));
				if(ancienneteResult.next()) {
					System.out.println(ancienneteResult.getString(1));
				}
				else {
					
				}
				ancienneteResult.close();
				subStmt.close();
				
			}
			stmt.close();
			result.close();
			ctn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}			
	}
}
