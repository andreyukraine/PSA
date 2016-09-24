package ua.artcode.view.swing.registration_forms;

import ua.artcode.controler.IClientController;
import ua.artcode.controler.IModeratorPSAController;
import ua.artcode.view.LoginView;
import ua.artcode.view.swing.Authorization;
import ua.artcode.view.swing.RegistrationMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IT on 22.09.2016.
 */
public class ModeratorPSAFrame extends JFrame{

    private JLabel fullnameLabel;
    private JButton exit;
    private IModeratorPSAController iModeratorPSAController;


    public ModeratorPSAFrame(IModeratorPSAController iModeratorPSAController) throws HeadlessException {

        setTitle("ModeratorPSAFrame form");
        setSize(600, 600);
        this.iModeratorPSAController = iModeratorPSAController;
        init(iModeratorPSAController);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    private void init(IModeratorPSAController iModeratorPSAController) {
        GridLayout gridLayout = new GridLayout(5, 2);
        setLayout(gridLayout);

        fullnameLabel = new JLabel("ModeratorPSA");
        exit = new JButton("Exit");
        exit.addActionListener(new ModeratorPSAFrame.CloseListener());
        getContentPane().add(fullnameLabel);
        getContentPane().add(exit);
    }

    private class CloseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //new Authorization(loginView).setVisible(true);

        }
    }

}
