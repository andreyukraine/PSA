package ua.artcode.view.swing.registration_forms;

import ua.artcode.controler.IClientController;
import ua.artcode.db.IAppDB;
import ua.artcode.model.Client;
import ua.artcode.model.Service;
import ua.artcode.view.LoginView;
import ua.artcode.view.swing.Authorization;
import ua.artcode.view.swing.RegistrationMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import static java.awt.SystemColor.menu;

/**
 * Created by IT on 22.09.2016.
 */
public class ClientFrame extends JFrame{


    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private JLabel fullnameLabel;
    private JButton exit;
    private IClientController iClientController;


    public ClientFrame(IClientController iClientController) throws HeadlessException {

        setTitle("Client form");
        setSize(600, 600);
        this.iClientController = iClientController;
        init(iClientController);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    private void init(IClientController iClientController) {



        GridLayout gridLayout = new GridLayout(5, 2);
        setLayout(gridLayout);


        JPanel flow = new JPanel( new FlowLayout( FlowLayout.LEFT, 12, 0) );
        JPanel grid = new JPanel( new GridLayout(1,1,0,0));

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("Menu");
        JMenuItem openItem = new JMenuItem("createOrder");
        JMenuItem openItem1 = new JMenuItem("searchService");
        JMenuItem openItem2 = new JMenuItem("listOrders");
        menu.add(openItem);
        menu.add(openItem1);
        menu.add(openItem2);
        menuBar.add(menu);

        grid.add(menuBar);
        flow.add(grid);

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
                                         dispose();
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

        getContentPane().add(flow);
        fullnameLabel = new JLabel("Client");
        getContentPane().add(fullnameLabel);
        getContentPane().add(new JScrollPane(myTable));

        //getContentPane().add(exit);
    }

//    public class CloseListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//           // new Authorization(loginView).setVisible(true);
//
//        }
//    }
}
