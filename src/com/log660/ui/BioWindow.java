package com.log660.ui;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class BioWindow extends JFrame{

    ContentsBio c;

    public BioWindow (ArrayList<String> donnees) {
        c = new ContentsBio(donnees);
        this.setVisible(true);
        this.add(c);
    }

    private class ContentsBio extends JPanel {

        public ContentsBio(ArrayList<String> donnees) {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.setVisible(true);

            //TODO chercher les infos a partir de l'objet o

            JLabel nomPersonne = new JLabel("Nom : " + donnees.get(0));
            this.add(nomPersonne);

            JLabel dateNaissance = new JLabel("Date de naissance : " + donnees.get(1));
            this.add(dateNaissance);

            JLabel lieuNaissance = new JLabel("Lieu de naissance : " + donnees.get(2));
            this.add(lieuNaissance);
            
        	JTextArea shortBio = new JTextArea(donnees.get(3),10,30);
            shortBio.setLineWrap(true);
            shortBio.setWrapStyleWord(true);
            shortBio.setMaximumSize(new Dimension(300,500));
            this.add(shortBio);
        }
    }
}
