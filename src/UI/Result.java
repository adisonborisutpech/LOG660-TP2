import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Result extends JPanel {
    DetailsWindow detW;

    public Result(List<Object> donnees) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);

        JLabel tInfos = new JLabel("Resultats de la recherche");
        this.add(tInfos);

        //debug
        String[] titres = {"Shrek (2001)","Shrek 2 (2004)", "Shrek the Third (2007)", "Shrek INFINITY (2053)"};

        JList liste = new JList(titres);
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
                //aller chercher l'objet courament selectionne dans donnees
                //l'envoyer a une nouvelle fenetre

             detW = new DetailsWindow(new Object());
             detW.pack();
            }
        });

    }
}
