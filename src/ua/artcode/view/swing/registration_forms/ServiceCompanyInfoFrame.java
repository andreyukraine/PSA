package ua.artcode.view.swing.registration_forms;

import ua.artcode.controler.IClientController;
import ua.artcode.model.Company;
import ua.artcode.model.Worker;
import ua.artcode.utils.Constants;
import ua.artcode.view.LoginView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by IT on 23.09.2016.
 */
public class ServiceCompanyInfoFrame extends JFrame {

    private JLabel Label;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JLabel Label4;
    private JButton prevButton;

    public ServiceCompanyInfoFrame(String companyName, IClientController iClientController) throws HeadlessException {

        setTitle("Company info form");
        setSize(600, 600);
        init(companyName, iClientController);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    private void init(String companyName, IClientController iClientController) {
        GridLayout gridLayout = new GridLayout(5, 1);
        setLayout(gridLayout);
        for (Map.Entry<String, Company> entry : iClientController.listAllCompany().entrySet()) {
            if (entry.getKey().equals(companyName)) {
                Label = new JLabel("Name company : " + entry.getValue().getNameCompany());
                Label1 = new JLabel("Description company : " + entry.getValue().getDescriptionCompany());
                Label2 = new JLabel("Location company : " + String.valueOf(entry.getValue().getLocation()));
                Label3 = new JLabel("Moderator company : " + String.valueOf(entry.getValue().getModerator()));
                Label4 = new JLabel("Status company : " + String.valueOf(entry.getValue().getChangeStatusCompany()));
            }
        }
        JPanel flow = new JPanel( new FlowLayout( FlowLayout.LEFT, 0, 0) );
        JPanel grid = new JPanel( new GridLayout(5,5,1,0));

        grid.add(Label);
        grid.add(Label1);
        grid.add(Label2);
        grid.add(Label3);
        grid.add(Label4);
        flow.add(grid);
        getContentPane().add(flow);

        String[] columns = new String[] {"Name worker", "Description", "Location"};

        DefaultTableModel defaultModel = new DefaultTableModel(columns, 0);

        JTable myTable = new JTable(defaultModel);

        JScrollPane scrollPane = new JScrollPane(myTable);



//        if (iClientController.showAllFreeWorker().size() != 0) {
//            for (Map.Entry<String, Worker> entry : iClientController.showAllFreeWorker().entrySet()) {
//                    defaultModel.addRow(new Object[]{
//                            entry.getValue().getFullname(), entry.getValue().getPhone(),
//                            entry.getValue().getStatus()});
//            }
//        }else{
           // Label5 = new JLabel("No free worker");
        // }

//        getContentPane().add(Label);
//        getContentPane().add(Label1);
//        getContentPane().add(Label2);
//        getContentPane().add(Label3);
//        getContentPane().add(Label4);

        getContentPane().add(Box.createVerticalStrut(25));

        getContentPane().add(new JScrollPane(myTable));





    }
}
