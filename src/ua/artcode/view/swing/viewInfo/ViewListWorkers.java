package ua.artcode.view.swing.viewInfo;

import ua.artcode.model.Service;
import ua.artcode.model.Worker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ua.artcode.view.swing.viewInfo.ViewDetailedInfoService;
import ua.artcode.view.swing.viewInfo.ViewDetailedInfoWorker;

/**
 * Created by work on 18.09.2016.
 */
public class ViewListWorkers extends JFrame{

    private Service service;

    public ViewListWorkers(Service service) throws HeadlessException {

        setLocation(350, 300);
        setTitle("Список работников выполняемых - " + service.getNameService());
        setSize(450,100);
        this.service = service;
        init();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    private void init() {


        GridLayout gridLayout = new GridLayout(service.getWorkers().size(),2);
        setLayout(gridLayout);

        JLabel [] nameWorkersLabel = new JLabel [service.getWorkers().size()];
        JButton [] detailedInfoWorker = new JButton [service.getWorkers().size()];

        for (int i = 0; i < service.getWorkers().size(); i++) {
            nameWorkersLabel[i] = new JLabel(service.getWorkers().get(i).getFullname());
            detailedInfoWorker [i] = new JButton("Detailed info Worker " + service.getWorkers().get(i).getFullname());

            Worker worker = service.getWorkers().get(i);

            detailedInfoWorker[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ViewDetailedInfoWorker(worker);
                }
            });
            getContentPane().add(nameWorkersLabel[i]);
            getContentPane().add(detailedInfoWorker[i]);
        }

    }
}
