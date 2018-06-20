package com.log660.ui;
import javax.swing.*;
import java.awt.*;

public class BioWindow extends JFrame{

    ContentsBio c;

    public BioWindow (Object o) {
        c = new ContentsBio();
        this.setVisible(true);
        this.add(c);
    }

    private class ContentsBio extends JPanel {

        public ContentsBio() {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.setVisible(true);

            //TODO chercher les infos a partir de l'objet o

            JLabel nomPersonne = new JLabel("Nom : " + "Mike Myers");
            this.add(nomPersonne);

            JLabel dateNaissance = new JLabel("Date de naissance : " + 1963);
            this.add(dateNaissance);

            JLabel lieuNaissance = new JLabel("Lieu de naissance : " + "Scarborough, Ontario");
            this.add(lieuNaissance);

            JTextArea shortBio = new JTextArea("bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla ",10,30);
            shortBio.setLineWrap(true);
            shortBio.setWrapStyleWord(true);
            shortBio.setMaximumSize(new Dimension(300,500));
            this.add(shortBio);
        }
    }
}
