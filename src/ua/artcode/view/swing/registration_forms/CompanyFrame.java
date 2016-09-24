package ua.artcode.view.swing.registration_forms;

import ua.artcode.controler.IClientController;
import ua.artcode.model.Company;
import ua.artcode.model.Service;
import ua.artcode.view.swing.RegistrationMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

/**
 * Created by IT on 23.09.2016.
 */
public class CompanyFrame extends JFrame {

    private JLabel fullnameLabel;
    private IClientController iClientController;
    private String serviceName;
    private JButton prevButton;

    public CompanyFrame(String serviceName, IClientController iClientController) throws HeadlessException {

        setTitle("Company view form");
        setSize(600, 600);
        this.serviceName = serviceName;
        this.iClientController = iClientController;
        init(serviceName, iClientController);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void init(String serviceName, IClientController iClientController) {
        GridLayout gridLayout = new GridLayout(5, 2);
        setLayout(gridLayout);

        String[] columns = new String[] {"Name company", "Description", "Location"};

        DefaultTableModel defaultModel = new DefaultTableModel(columns, 0);

        JTable myTable = new JTable(defaultModel);

        JScrollPane scrollPane = new JScrollPane(myTable);


        for (Map.Entry<String, Company> entry : iClientController.listAllCompany().entrySet()) {

            if (entry.getValue().getServices().getNameService().equals(serviceName)){
                defaultModel.addRow(new Object[] {
                        entry.getValue().getNameCompany(), entry.getValue().getDescriptionCompany(),
                        entry.getValue().getLocation()});
            }
        }

        myTable.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                int column = myTable.columnAtPoint(point);
                TableModel model = myTable.getModel();
                Object value = model.getValueAt(myTable.rowAtPoint(e.getPoint()), myTable.columnAtPoint(e.getPoint()));
                new ServiceCompanyInfoFrame(String.valueOf(value), iClientController);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        fullnameLabel = new JLabel(serviceName);
        getContentPane().add(fullnameLabel);
        getContentPane().add(new JScrollPane(myTable));


        JPanel flow = new JPanel( new FlowLayout( FlowLayout.LEFT, 0, 0) );
        JPanel grid = new JPanel( new GridLayout(2,2,2,0));
        prevButton = new JButton("< prev");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ClientFrame(iClientController).setVisible(true);
            }
        });
        grid.add(prevButton);
        flow.add(grid);
        getContentPane().add(flow);
    }


}
