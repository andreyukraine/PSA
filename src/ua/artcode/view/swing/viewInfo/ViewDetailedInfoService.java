package ua.artcode.view.swing.viewInfo;

import ua.artcode.model.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by work on 18.09.2016.
 */
public class ViewDetailedInfoService extends JFrame{

    private Service service;

    public ViewDetailedInfoService(Service service) throws HeadlessException {

        setLocation(350, 300);
        setTitle("Detailed info Service - " + service.getNameService());
        setSize(450,150);
        this.service = service;
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init();
    }

    private void init() {


        GridLayout gridLayout = new GridLayout(2,1);
        setLayout(gridLayout);

        JPanel firstLayout = new JPanel(new GridLayout(3,2));

        JLabel rateTextLabel = new JLabel("Rate");
        JLabel rateLabel = new JLabel(service.getRateService().toString());

        JLabel countOfWorkersLabel = new JLabel("Count Workers of Service:    " + "<" + service.getWorkers().size() + ">");

        JButton showWorkers = new JButton("Show list of Workers");
        showWorkers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewListWorkers(service);
            }
        });

        JPanel countComment = new JPanel(new GridLayout(1,2));
        JLabel commentsOfServiceLabel = new JLabel("Count comments of Service:  " + "<" +  service.getCommentsService().size() + ">");
        countComment.add(commentsOfServiceLabel);
        countComment.add(commentsOfServiceLabel);

        JButton showComments = new JButton("Show list of comments");
        showComments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewListCommentsOfService(service);
            }
        });


        JTextArea textArea = new JTextArea();
        textArea.setText(service.getDescriptionService());

        getContentPane().add(firstLayout);
        firstLayout.add(rateTextLabel);
        firstLayout.add(rateLabel);
        firstLayout.add(countOfWorkersLabel);
        firstLayout.add(showWorkers);
        firstLayout.add(countComment);
        firstLayout.add(showComments);
        getContentPane().add(textArea);

    }
}
