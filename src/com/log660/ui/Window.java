package com.log660.ui;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame{

    JPanel loginPanel;
    JPanel searchPanel;
    JPanel resultsPanel;

    public Window () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        createLoginPanel();
    }

    public void switchToSearchPanel () {
            System.out.println("Switching to search panel");
            this.getContentPane().removeAll();
            createSearchPanel();
            this.add(searchPanel);
            this.pack();
            this.repaint();
    }

    public void switchToResultsPanel (ArrayList<ArrayList<String>> resultBD) {
        System.out.println("Switching to result panel");
        this.getContentPane().removeAll();
        createResultPanel(resultBD);
        this.add(resultsPanel);
        this.pack();
        this.repaint();
    }

    private void createLoginPanel () {
        loginPanel = new Login();
        this.add(loginPanel);
        this.setPreferredSize(new Dimension(400,150));
        this.pack();

        this.repaint();
    }

    private void createSearchPanel () {
        searchPanel = new Search();
        this.setPreferredSize(new Dimension(400,300));
        this.add(searchPanel);
        this.pack();

        this.repaint();
    }

    private void createResultPanel (ArrayList<ArrayList<String>> retourBD) {
        resultsPanel = new Result(retourBD);
        this.setPreferredSize(new Dimension(400,600));
        this.add(resultsPanel);
        this.pack();

        this.repaint();
    }
}
