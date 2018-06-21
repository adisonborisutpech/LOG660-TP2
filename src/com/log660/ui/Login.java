package com.log660.ui;
import javax.swing.*;

import com.log660.controllers.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel {

    public Login () {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        this.setSize(800,600);

        JLabel nameLabel = new JLabel("courriel de l'utilisateur");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField nameLogin  = new JTextField();
        nameLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passwordLogin = new JPasswordField();
        passwordLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean loginOk;
                loginOk = Controller.attemptLogin(nameLogin.getText(),String.valueOf(passwordLogin.getPassword()));
                if (loginOk) {Controller.getWindowInstance().switchToSearchPanel();}

                }
            }
        );

        this.add(nameLabel);
        this.add(nameLogin);
        this.add(passwordLabel);
        this.add(passwordLogin);
        this.add(loginButton);
        loginButton.setVisible(true);
        passwordLogin.setVisible(true);
        loginButton.setVisible(true);
    }
}
