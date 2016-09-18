package ua.artcode.view.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aleksandrnagorniy on 18.09.16.
 */
public class MainFrame extends JFrame{


    private JLabel invitationLable;
    private JPanel authorizationPanel;
    private JLabel authorizationLable;
    private JLabel newUserLable;
    private JPanel newUserPanel;
    private JButton authorizationButton;
    private JButton newUserButton;

    public MainFrame() throws HeadlessException {

        setTitle("MAIN, Public Service Application");
        setSize(600, 600);
        init();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void init() {

        GridLayout gridLayout = new GridLayout(3, 1);
        setLayout(gridLayout);

        invitationLable = new JLabel("Welcome to PSA!!! This programm is made by students of ACO15 group");

        authorizationPanel = new JPanel(new GridLayout(1, 2));
        authorizationLable = new JLabel("If you have already register user");
        authorizationButton = new JButton("Authorization");
        authorizationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Authorization().setVisible(true);
            }
        });

        newUserPanel = new JPanel(new GridLayout(1, 2));
        newUserLable = new JLabel("Otherwise");
        newUserButton = new JButton("New user");
        newUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RegistrationMenu().setVisible(true);
            }
        });


        getContentPane().add(invitationLable);

        authorizationPanel.add(authorizationLable);
        authorizationPanel.add(authorizationButton);
        getContentPane().add(authorizationPanel);

        newUserPanel.add(newUserLable);
        newUserPanel.add(newUserButton);
        getContentPane().add(newUserPanel);

    }
}
