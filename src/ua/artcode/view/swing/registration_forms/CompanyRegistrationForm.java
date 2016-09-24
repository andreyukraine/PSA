package ua.artcode.view.swing.registration_forms;

import ua.artcode.view.LoginView;
import ua.artcode.view.swing.MainFrame;
import ua.artcode.view.swing.RegistrationMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aleksandrnagorniy on 18.09.16.
 */
public class CompanyRegistrationForm extends JFrame{

    private JLabel fullnameLabel;
    private JTextField fullnameField;
    private JLabel descriptionLable;
    private JTextArea descriptionArea;
    private JLabel countryLable;
    private JComboBox countryComboBox;
    private JLabel cityLable;
    private JComboBox cityComboBox;
    private JLabel loginLable;
    private JTextField loginField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton prevButton;
    private JButton registerButton;

    public CompanyRegistrationForm() throws HeadlessException {

        setTitle("Client regisrtation form");
        setSize(600, 600);
        init();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    private void init() {
        GridLayout gridLayout = new GridLayout(7, 2);
        setLayout(gridLayout);

        fullnameLabel = new JLabel("Fullname of company");
        fullnameField = new JTextField();

        descriptionLable = new JLabel("Description of company");
        descriptionArea = new JTextArea();

        countryLable = new JLabel("Country");
        countryComboBox = new JComboBox();

        cityLable = new JLabel("City");
        cityComboBox = new JComboBox();

        loginLable = new JLabel("Login");
        loginField = new JTextField();

        passwordLabel = new JLabel("Passwword");
        passwordField = new JPasswordField();

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
               // new MainFrame().setVisible(true);
            }
        });

        getContentPane().add(fullnameLabel);
        getContentPane().add(fullnameField);
        getContentPane().add(descriptionLable);
        getContentPane().add(descriptionArea);
        getContentPane().add(countryLable);
        getContentPane().add(countryComboBox);
        getContentPane().add(cityLable);
        getContentPane().add(cityComboBox);
        getContentPane().add(loginLable);
        getContentPane().add(loginField);
        getContentPane().add(passwordLabel);
        getContentPane().add(passwordField);
        getContentPane().add(prevButton);
        getContentPane().add(registerButton);
    }
}
