package com.log660.ui;
import javax.swing.*;

import com.log660.controllers.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Result extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DetailsWindow detW;

    public Result(ArrayList<ArrayList<String>> donnees) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);

        JLabel tInfos = new JLabel("Resultats de la recherche");
        this.add(tInfos);
        ArrayList<String> titres = new ArrayList<String>();
        ArrayList<String> ids = new ArrayList<String>();
        //debug
        for(ArrayList<String> film : donnees) {
        	titres.add(film.get(0));
        	ids.add(film.get(1));
        }

		JList<Object> liste = new JList<Object>(titres.toArray());
        /*
        for (Object o : donnees) {
            //TODO aller chercher le titre et l'annee du film et creer la liste en bon format
        }
        */

        JScrollPane listeFilms = new JScrollPane(liste);
        this.add(listeFilms);

        JButton boutonDetails = new JButton("Details sur le film");
        this.add(boutonDetails);

        boutonDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             ArrayList<ArrayList<String>> results = Controller.getFilmById(Integer.parseInt(ids.get(liste.getSelectedIndex())));

             detW = new DetailsWindow(results);
             detW.pack();
            }
        });
        
        JButton retour = new JButton("Retour");
        this.add(retour);
        
        retour.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        		Controller.getWindowInstance().switchToSearchPanel();
        	}
        });

    }
}
