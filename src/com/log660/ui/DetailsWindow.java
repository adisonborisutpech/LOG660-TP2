package com.log660.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsWindow extends JFrame {

    Contents c;
    BioWindow bioW;

    public DetailsWindow (Object o) {
        c = new Contents();
        this.setVisible(true);
        this.add(c);
    }


    private class Contents extends JPanel {

        public Contents() {
            this.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            this.setVisible(true);

            //TODO tous les elements ici doivent aller chercher les infos de l'objet o

            JLabel titreFilm = new JLabel("Titre du film : " + "Shrek");
            c.gridx = 0 ;c.gridy = 0; c.weightx = 0.5; c.weighty = 0.05;
            this.add(titreFilm,c);

            JLabel anneeFilm = new JLabel("Annee de sortie : " + "2001");
            c.gridx = 0 ;c.gridy = 1; c.weightx = 0.5; c.weighty = 0.05;
            this.add(anneeFilm, c);

            //TODO construire une string a partir des donnees
            String paysProduction = "USA, USA, USA, AMERICA, ETC";

            JLabel paysFilm =  new JLabel("Pays de production : " + paysProduction);
            c.gridx = 0 ;c.gridy = 2; c.weightx = 0.5; c.weighty = 0.05;
            this.add(paysFilm, c);

            JLabel langueFilm = new JLabel("Langue originale : " + "Anglais");
            c.gridx = 0 ;c.gridy = 3; c.weightx = 0.5; c.weighty = 0.05;
            this.add(langueFilm,c);

            JLabel dureeFilm = new JLabel("Duree du film : " + "1h30m");
            c.gridx = 0 ;c.gridy = 4; c.weightx = 0.5; c.weighty = 0.05;
            this.add(dureeFilm,c);

            //TODO construire une stringe des genres du film
            String genres = "Ogre, Onion, Donkey";

            JLabel genreFilm = new JLabel(genres);
            c.gridx = 0 ;c.gridy = 5; c.weightx = 0.5; c.weighty = 0.05;
            this.add(genreFilm,c);

            JLabel realisateurFilm = new JLabel("Realisateur : " + "Andrew Adamson");
            c.gridx = 0 ;c.gridy = 6; c.weightx = 0.5; c.weighty = 0.05;
            this.add(realisateurFilm,c);

            JButton infosRealisateur = new JButton("Biographie du realisateur");
            c.gridx = 0 ;c.gridy = 7; c.weightx = 0.5; c.weighty = 0.05;
            this.add(infosRealisateur,c);

            infosRealisateur.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO creer un autre popup avec la bio
                    System.out.println("infos du realisateur");
                }
            });

            //TODO generer les listes des scenaristes et des acteurs (roles)
            String[] scenaristes = {"Ted Elliot", "Terry Rosso", "Joe Stillman"};
            JList listeScenaristes = new JList(scenaristes);

            String[] acteurs = {"Mike Myers (Shrek)","Eddie Murphy (Donkey)","Cameron Diaz (Fiona)"};
            JList listeActeurs = new JList(acteurs);

            JLabel scenaristesText = new JLabel("Scenaristes");
            c.gridx = 0 ;c.gridy = 8; c.weightx = 0.5; c.weighty = 0.05;
            this.add(scenaristesText,c);

            JScrollPane scenatistesPane = new JScrollPane(listeScenaristes);
            c.gridx = 0 ;c.gridy = 9; c.weightx = 0.5; c.weighty = 0.2;
            this.add(scenatistesPane,c);

            JLabel acteursText = new JLabel("Acteurs");
            c.gridx = 0 ;c.gridy = 10; c.weightx = 0.5; c.weighty = 0.05;
            this.add(acteursText,c);

            JScrollPane acteursPane = new JScrollPane(listeActeurs);
            c.gridx = 0 ;c.gridy = 11; c.weightx = 0.5; c.weighty = 0.2;
            this.add(acteursPane,c);

            JButton acteursBio = new JButton("Biographie acteur");
            c.gridx = 0 ;c.gridy = 12; c.weightx = 0.5; c.weighty = 0.075;
            this.add(acteursBio,c);

            acteursBio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO selon l'acteur selectionne, creer un popup avec la bio
                    bioW = new BioWindow(new Object());
                    bioW.pack();
                }
            });

            JTextArea resumeScenario = new JTextArea("After his swamp is filled with magical creatures, Shrek agrees to rescue Princess Fiona for a villainous lord in order to get his land back.",5,40);
            c.gridx = 0 ;c.gridy = 13; c.weightx = 0.5; c.weighty = 0.15;
            resumeScenario.setLineWrap(true);
            resumeScenario.setWrapStyleWord(true);
            resumeScenario.setMaximumSize(new Dimension(300,100));
            this.add(resumeScenario,c);

            JLabel copiesFilmText = new JLabel("Copies disponibles : " + 999999);
            c.gridx = 0 ;c.gridy = 14; c.weightx = 0.5; c.weighty = 0.05;
            this.add(copiesFilmText,c);

            JButton boutonLocation = new JButton("Louer une copie");
            c.gridx = 0 ;c.gridy = 15; c.weightx = 0.5; c.weighty = 0.05;
            this.add(boutonLocation,c);

            boutonLocation.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO access a la BD pour location, creer un toast dependant du resultat
                    createPopupLocation(true);
                    createPopupLocation(false);

                }
            });


            }



        }

        public void createPopupLocation (boolean succes) {

        if (succes) JOptionPane.showMessageDialog(this,"La location a ete effectuee","Location",JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(this, "La location a echouee","Location",JOptionPane.OK_OPTION);
        }

}
