package ua.artcode.view.swing;

import ua.artcode.utils.Constants;
import ua.artcode.view.swing.registration_forms.ClientRegistrationForm;
import ua.artcode.view.swing.registration_forms.CompanyRegistrationForm;
import ua.artcode.view.swing.registration_forms.WorkerRegistrationForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aleksandrnagorniy on 18.09.16.
 */
public class RegistrationMenu extends JFrame {

    private JRadioButton companyRadioBox;
    private JRadioButton workerRadioBox;
    private JRadioButton clientRadioBox;
    private JButton prevButton;
    private JButton nextButton;

    public RegistrationMenu() {

        setTitle("Registration");
        setSize(Constants.VIEW_WIDTH, Constants.VIEW_HIGHT-100);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        init();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    private void init() {

        GridLayout gridLayout = new GridLayout(4, 1);
        setLayout(gridLayout);


        companyRadioBox = new JRadioButton("new Company");
        workerRadioBox = new JRadioButton("new Worker");
        clientRadioBox = new JRadioButton("new Client", true);

        ButtonGroup groupRadioBoxes = new ButtonGroup();
        groupRadioBoxes.add(companyRadioBox);
        groupRadioBoxes.add(workerRadioBox);
        groupRadioBoxes.add(clientRadioBox);


        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        prevButton = new JButton("< prev");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               // new MainFrame().setVisible(true);
            }
        });

        nextButton = new JButton("next >");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if (groupRadioBoxes.getSelection() == companyRadioBox.getModel()){
                    new CompanyRegistrationForm().setVisible(true);
                } else if (groupRadioBoxes.getSelection() == workerRadioBox.getModel()){
                    new WorkerRegistrationForm().setVisible(true);
                } else if (groupRadioBoxes.getSelection() == clientRadioBox.getModel()) {
                    new ClientRegistrationForm().setVisible(true);
                }
            }
        });

        getContentPane().add(companyRadioBox);
        getContentPane().add(workerRadioBox);
        getContentPane().add(clientRadioBox);

        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        getContentPane().add(buttonPanel);

    }
}
