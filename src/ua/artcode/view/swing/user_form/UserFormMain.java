package ua.artcode.view.swing.user_form;

import ua.artcode.model.User;
import ua.artcode.utils.Constants;
import ua.artcode.view.swing.Authorization;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.util.Map;

/**
 * Created by lost on 18.09.2016.
 */
public class UserFormMain extends JFrame {

    private JButton[] actions = new JButton[4];
    private User user;
    private boolean ordersSetting;
    private Font font;

    public UserFormMain(User user) throws HeadlessException {
        this.user = user;
        font = new Font("Verdana", Font.PLAIN, 12);
        setTitle("Public Service Application");
        setSize(Constants.VIEW_WIDTH, Constants.VIEW_HIGHT);
        setBackground(Color.WHITE);
        init();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void init() {

        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        GridLayout gridLayout = new GridLayout(2, 1);
        setLayout(gridLayout);

        JPanel fullHead = new JPanel(new GridLayout(2, 1));
        JPanel head = new JPanel(new GridLayout(1, 6));
        JPanel emptyhead = new JPanel();
        emptyhead.setBackground(Color.WHITE);


        ImageIcon image = new ImageIcon("images\\user icon.png");
        JLabel imageLabel = new JLabel(image);
        JLabel[] emptyLabel = new JLabel[8];
        imageLabel.setVisible(true);
        JLabel userName = new JLabel(user.getEmail());
        userName.setFont(font.deriveFont(attributes));

        head.setBackground(Color.WHITE);
        head.add(imageLabel);
        head.add(userName);

        for (int i = 0; i <= 2; i++) {
            emptyLabel[i] = new JLabel("");
            head.add(emptyLabel[i]);
        }
        ImageIcon imageLogoff = new ImageIcon("images\\logoff.png");
        JButton imageLogof = new JButton(imageLogoff);
        imageLogof.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Authorization authorization=new Authorization();
            }
        });
        imageLogof.setBackground(Color.WHITE);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        imageLogof.setBorder(emptyBorder);

        head.add(imageLogof);

        JPanel body = new JPanel(new GridLayout(1, 3));
        actions[0] = new JButton("Add");
        actions[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!ordersSetting)
                    addOrder();
            }
        });
        actions[0].setIcon(new ImageIcon("images\\add.png"));
        actions[1] = new JButton("Find");
        actions[1].setIcon(new ImageIcon("images\\find.png"));
        actions[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 22.09.16 realizatoin filds find driver
                findDriver();
            }
        });
        actions[2] = new JButton("Show all");
        actions[2].setIcon(new ImageIcon("images\\showall.png"));
        // actions[3] = new JButton("Log off");
        //  actions[3].setIcon(new ImageIcon("images\\logoff.png"));
        for (int i = 0; i <= 2; i++) {
            actions[i].setFont(font);
            actions[i].setBackground(Color.WHITE);
            body.add(actions[i]);
        }
        fullHead.add(head);
        fullHead.add(emptyhead);


        getContentPane().add(fullHead);
        getContentPane().add(body);

    }

    private void addOrder() {
        ordersSetting = true;
        GridLayout gridLayout = new GridLayout(3, 1);
        getContentPane().setPreferredSize(new Dimension(Constants.VIEW_WIDTH, Constants.VIEW_HIGHT+100));
        getContentPane().setLayout(gridLayout);

        JPanel costPanel = new JPanel(new GridLayout(1, 1));
        JTextField costField = new JTextField();
        costPanel.setBackground(Color.WHITE);
        costPanel.add(costField);
        JPanel orderPanel = new JPanel(new GridLayout(5, 2));
        JPanel orderPanelButtom = new JPanel(new GridLayout(1, 5));
        JButton costOrder = new JButton("Cost");
        costOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 22.09.16 realizatoin filds cost
                cost();
            }
        });

        orderPanel.setFont(font);
        orderPanelButtom.setFont(font);
        orderPanel.setBackground(Color.WHITE);
        orderPanelButtom.setBackground(Color.WHITE);
        JLabel timeLabel = new JLabel("Time ");
        JLabel fromLabel = new JLabel("From ");
        JLabel whereLabel = new JLabel("Where ");
        JLabel descriptionOrder = new JLabel("Description ");

        JPanel timePanel = new JPanel(new GridLayout(1, 3));
        JTextField fromLabeldate = new JTextField("Date");
        fromLabeldate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fromLabeldate.getText().equals("Date")) {
                    fromLabeldate.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        JTextField hour = new JTextField("Hour");
        hour.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (hour.getText().equals("Hour")) {
                    hour.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        JTextField minutes = new JTextField("Minutes");
        minutes.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (minutes.getText().equals("Minutes")) {
                    minutes.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        timePanel.add(fromLabeldate);
        timePanel.add(hour);
        timePanel.add(minutes);

        JPanel fromPanel = new JPanel(new GridLayout(1, 3));
        JTextField fromCity = new JTextField("City");
        fromCity.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fromCity.getText().equals("City"))
                    fromCity.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fromCity.getText().equals(""))
                    fromCity.setText("City");
            }
        });


        JTextField fromStreet = new JTextField("Street");
        fromStreet.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fromStreet.getText().equals("Street"))
                    fromStreet.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fromStreet.getText().equals(""))
                    fromStreet.setText("Street");
            }
        });

        JTextField fromHouse = new JTextField("House");

        fromHouse.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fromHouse.getText().equals("House"))
                    fromHouse.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fromHouse.getText().equals(""))
                    fromHouse.setText("House");
            }
        });
        fromPanel.add(fromCity);
        fromPanel.add(fromStreet);
        fromPanel.add(fromHouse);

        JPanel wherePanel = new JPanel(new GridLayout(1, 3));
        JTextField whereCity = new JTextField();
        JTextField whereStreet = new JTextField();
        JTextField whereHouse = new JTextField();
        wherePanel.add(whereCity);
        wherePanel.add(whereStreet);
        wherePanel.add(whereHouse);

        JTextField descriptionField = new JTextField();
        orderPanelButtom.add(costOrder);


        orderPanel.add(timeLabel);
        orderPanel.add(timePanel);
        orderPanel.add(fromLabel);
        orderPanel.add(fromPanel);
        orderPanel.add(whereLabel);
        orderPanel.add(wherePanel);
        orderPanel.add(descriptionOrder);
        orderPanel.add(descriptionField);
        orderPanel.add(orderPanelButtom);
        orderPanel.add(costPanel);


        getContentPane().add(orderPanel);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private boolean findDriver() {
        return false;
    }
    private double cost() {
        return 0;
    }

}
