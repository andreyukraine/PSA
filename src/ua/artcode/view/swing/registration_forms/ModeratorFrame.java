package ua.artcode.view.swing.registration_forms;

import ua.artcode.controler.IModeratorController;
import ua.artcode.view.LoginView;
import ua.artcode.view.swing.RegistrationMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by IT on 21.09.2016.
 */
public class ModeratorFrame extends JFrame{

    private JLabel fullnameLabel;

    public ModeratorFrame(IModeratorController iModeratorController) throws HeadlessException {

        setTitle("Moderator form");
        setSize(600, 600);
        init(iModeratorController);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    private void init(IModeratorController iModeratorController) {
        GridLayout gridLayout = new GridLayout(5, 2);
        setLayout(gridLayout);

        fullnameLabel = new JLabel("Moderator");
        getContentPane().add(fullnameLabel);
    }

}
