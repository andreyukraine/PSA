package ua.artcode.view.swing.registration_forms;

import ua.artcode.view.swing.MainFrame;
import ua.artcode.view.swing.RegistrationMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aleksandrnagorniy on 18.09.16.
 */
public class WorkerRegistrationForm extends JFrame {

    private JLabel fullnameLabel;
    private JTextField fullnameField;
    private JLabel emailLable;
    private JTextField emailField;
    private JLabel phoneLable;
    private JTextField phoneField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel companyLabel;
    private JTextField companyField;
    private JButton prevButton;
    private JButton registerButton;

    public WorkerRegistrationForm() throws HeadlessException {

        setTitle("Worker registration form");
        setSize(600, 600);
        init();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    private void init() {
        GridLayout gridLayout = new GridLayout(6, 2);
        setLayout(gridLayout);

        fullnameLabel = new JLabel("Fullname");
        fullnameField = new JTextField();

        emailLable = new JLabel("E-mail");
        emailField = new JTextField();

        phoneLable = new JLabel("Phone number");
        phoneField = new JTextField("+380");

        passwordLabel = new JLabel("Passwword");
        passwordField = new JPasswordField();

        companyLabel = new JLabel("Company");
        companyField = new JTextField();

        prevButton = new JButton("< prev");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistrationMenu().setVisible(true);
            }
        });

        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 18.09.16 validation registration form...
                dispose();
                JOptionPane.showMessageDialog(getParent(),
                        "There must be answer of validation registration. " +
                                "But now you'll just go to main frame :(");
                new MainFrame().setVisible(true);
            }
        });


        getContentPane().add(fullnameLabel);
        getContentPane().add(fullnameField);
        getContentPane().add(emailLable);
        getContentPane().add(emailField);
        getContentPane().add(phoneLable);
        getContentPane().add(phoneField);
        getContentPane().add(passwordLabel);
        getContentPane().add(passwordField);
        getContentPane().add(companyLabel);
        getContentPane().add(companyField);
        getContentPane().add(prevButton);
        getContentPane().add(registerButton);
    }
}
