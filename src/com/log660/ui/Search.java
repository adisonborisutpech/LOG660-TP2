package com.log660.ui;
import javax.swing.*;

import com.log660.controllers.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Search extends JPanel {

    public Search() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        this.setVisible(true);


        JLabel instructionsRecherche = new JLabel("Recherche de films ");
        c.gridx = 0 ;c.gridy = 0; c.weightx = 0.3; c.weighty = 0.1;
        this.add(instructionsRecherche, c);

        JLabel tTitre = new JLabel("Titre contient: ");
        c.gridx = 0; c.gridy = 1; c.weightx = 0.3; c.weighty = 0.1;
        this.add(tTitre, c);

        JTextField titreFilm = new JTextField();
        c.gridx = 1; c.gridy = 1; c.weightx = 0.7; c.weighty = 0.1;
        this.add(titreFilm, c);

        JLabel tAnnee1 = new JLabel("Annee de sortie > : ");
        c.gridx = 0; c.gridy = 2; c.weightx = 0.3; c.weighty = 0.1;
        this.add(tAnnee1, c);

        JTextField anneeFilm1 = new JTextField();
        c.gridx = 1; c.gridy = 2; c.weightx = 0.7; c.weighty = 0.1;
        this.add(anneeFilm1, c);

        JLabel tAnnee2 = new JLabel("Annee de sortie < : ");
        c.gridx = 0; c.gridy = 3; c.weightx = 0.3; c.weighty = 0.1;
        this.add(tAnnee2, c);

        JTextField anneeFilm2 = new JTextField();
        c.gridx = 1; c.gridy = 3; c.weightx = 0.7; c.weighty = 0.1;
        this.add(anneeFilm2, c);

        JLabel tPays = new JLabel("Pays de production: ");
        c.gridx = 0; c.gridy = 4; c.weightx = 0.3; c.weighty = 0.1;
        this.add(tPays, c);

        JTextField paysFilm = new JTextField();
        c.gridx = 1; c.gridy = 4; c.weightx = 0.7; c.weighty = 0.1;
        this.add(paysFilm, c);

        JLabel tLangue = new JLabel("Langue originale: ");
        c.gridx = 0; c.gridy = 5; c.weightx = 0.3; c.weighty = 0.1;
        this.add(tLangue, c);

        JTextField langueFilm = new JTextField();
        c.gridx = 1; c.gridy = 5; c.weightx = 0.7; c.weighty = 0.1;
        this.add(langueFilm, c);

        JLabel tGenre = new JLabel("Genre du film: ");
        c.gridx = 0; c.gridy = 6; c.weightx = 0.3; c.weighty = 0.1;
        this.add(tGenre, c);

        JTextField genreFilm = new JTextField();
        c.gridx = 1; c.gridy = 6; c.weightx = 0.7; c.weighty = 0.1;
        this.add(genreFilm, c);

        JLabel tActeurs = new JLabel("Acteurs: ");
        c.gridx = 0; c.gridy = 7; c.weightx = 0.3; c.weighty = 0.1;
        this.add(tActeurs, c);

        JTextField acteursFilm = new JTextField();
        c.gridx = 1; c.gridy = 7; c.weightx = 0.7; c.weighty = 0.1;
        this.add(acteursFilm, c);

        JLabel tRealis = new JLabel("Realisateur: ");
        c.gridx = 0; c.gridy = 8; c.weightx = 0.3; c.weighty = 0.1;
        this.add(tRealis, c);

        JTextField realisFilm = new JTextField();
        c.gridx = 1; c.gridy = 8; c.weightx = 0.7; c.weighty = 0.1;
        this.add(realisFilm, c);

        JButton boutonRecherche = new JButton("Rechercher");
        c.gridx = 0; c.gridy = 9; c.weightx = 0.3; c.weighty = 0.1;
        this.add(boutonRecherche, c);


        boutonRecherche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<ArrayList<String>> resultat = Controller.searchMovie(titreFilm.getText(),extraireDate(anneeFilm1.getText()), extraireDate(anneeFilm2.getText()),
                        commaSeparator(paysFilm.getText()), commaSeparator(langueFilm.getText()), commaSeparator(genreFilm.getText()),
                        commaSeparator(acteursFilm.getText()),commaSeparator(realisFilm.getText()));

                Controller.getWindowInstance().switchToResultsPanel(resultat);
            }
        });


    }

    private int extraireDate (String readLine) {
        int annee = -1;
        //valeur defaut en tout cas d'erreur

        try {
            annee = Integer.valueOf(readLine);
        }
        catch (Exception e) {
            //ignorer
        }
        return annee;

    }

    private String[] commaSeparator (String readLine) {

        return readLine.split("\\s*,\\s*");

        //code empreunte/inspire de https://stackoverflow.com/questions/10631715/how-to-split-a-comma-separated-string

    }
}
