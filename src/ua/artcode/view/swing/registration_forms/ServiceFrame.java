package ua.artcode.view.swing.registration_forms;

import ua.artcode.controler.IClientController;
import ua.artcode.model.Company;
import ua.artcode.model.Service;
import ua.artcode.view.LoginView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

/**
 * Created by IT on 23.09.2016.
 */
public class ServiceFrame extends JFrame {

    private JLabel fullnameLabel;
    private IClientController iClientController;

    public ServiceFrame(String serviceName, IClientController iClientController) throws HeadlessException {

        setTitle("Service view form");
        setSize(600, 600);
        this.iClientController = iClientController;
        init(serviceName, iClientController);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void init(String serviceName, IClientController iClientController) {
        GridLayout gridLayout = new GridLayout(5, 2);
        setLayout(gridLayout);

        String[] columns = new String[] {"Name service", "Description", "Rate"};

        DefaultTableModel defaultModel = new DefaultTableModel(columns, 0);

        JTable myTable = new JTable(defaultModel);

        JScrollPane scrollPane = new JScrollPane(myTable);

        for (Map.Entry<String, Service> entry : iClientController.listAllService().entrySet()) {
            defaultModel.addRow(new Object[] {entry.getValue().getNameService(), entry.getValue().getDescriptionService(), entry.getValue().getRateService()});
        }

        myTable.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                int column = myTable.columnAtPoint(point);
                TableModel model = myTable.getModel();
                Object value = model.getValueAt(myTable.rowAtPoint(e.getPoint()), myTable.columnAtPoint(e.getPoint()));
                new CompanyFrame(String.valueOf(value), iClientController);
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
    }
}
