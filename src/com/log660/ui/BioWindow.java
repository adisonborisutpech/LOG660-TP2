package com.log660.ui;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;

import com.log660.beans.Personne;

public class BioWindow extends JFrame{

    ContentsBio c;

    public BioWindow (Object o) {
        c = new ContentsBio(o);
        this.setVisible(true);
        this.add(c);
    }

    private class ContentsBio extends JPanel {

        public ContentsBio(Object o) {
        	Personne personne = (Personne)o;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.setVisible(true);

            //TODO chercher les infos a partir de l'objet o

            JLabel nomPersonne = new JLabel("Nom : " + personne.getNom());
            this.add(nomPersonne);

            JLabel dateNaissance = new JLabel("Date de naissance : " + personne.getDatenaissance());
            this.add(dateNaissance);

            JLabel lieuNaissance = new JLabel("Lieu de naissance : " + personne.getLieunaissance());
            this.add(lieuNaissance);

            String bioString = "";
        	try {
                bioString = personne.getBiographie().getSubString(1, (int) personne.getBiographie().length());
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}//5
        	JTextArea shortBio = new JTextArea(bioString,10,30);
            shortBio.setLineWrap(true);
            shortBio.setWrapStyleWord(true);
            shortBio.setMaximumSize(new Dimension(300,500));
            this.add(shortBio);
        }
    }
}
