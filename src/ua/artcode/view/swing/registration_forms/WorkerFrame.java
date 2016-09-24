package ua.artcode.view.swing.registration_forms;

import ua.artcode.controler.IWorkerController;
import ua.artcode.view.LoginView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IT on 22.09.2016.
 */
public class WorkerFrame extends JFrame {


    private JLabel fullnameLabel;

    public WorkerFrame(IWorkerController iWorkerController) throws HeadlessException {

        setTitle("Worker form");
        setSize(600, 600);
        init();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    private void init() {
        GridLayout gridLayout = new GridLayout(5, 2);
        setLayout(gridLayout);

        fullnameLabel = new JLabel("Worker");
        getContentPane().add(fullnameLabel);
    }
}
