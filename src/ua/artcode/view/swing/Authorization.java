package ua.artcode.view.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aleksandrnagorniy on 18.09.16.
 */
public class Authorization extends JFrame{

    private JLabel loginLable;
    private JTextField loginText;
    private JLabel passLable;
    private JPasswordField passField;
    private JButton acceptButton;
    private JButton cancelButton;

    public Authorization() throws HeadlessException {

        setTitle("Authorization");
        setSize(600, 600);
        init();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    private void init() {
        GridLayout gridLayout = new GridLayout(3, 2);
        setLayout(gridLayout);

        loginLable = new JLabel("Login: ");
        loginText = new JTextField();

        passLable = new JLabel("Password: ");
        passField = new JPasswordField();

        acceptButton = new JButton("Accept");
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 18.09.16 must be call to programm and validation login and pass
                JOptionPane.showMessageDialog(getParent(), "There must be answer of validation login & password");
                dispose();
                // TODO: 18.09.16 must go to client frame(frame with actions for this current user)
                new MainFrame().setVisible(true);
            }
        });


        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainFrame().setVisible(true);
            }
        });

        getContentPane().add(loginLable);
        getContentPane().add(loginText);
        getContentPane().add(passLable);
        getContentPane().add(passField);
        getContentPane().add(acceptButton);
        getContentPane().add(cancelButton);

    }
}
