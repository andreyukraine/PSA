package ua.artcode.view;

import ua.artcode.controler.IWorkerController;
import ua.artcode.db.IAppDB;

import java.util.Scanner;

/**
 * Created by IT on 25.08.2016.
 */
public class WorkerView {

    private Scanner scanner;
    private IWorkerController iWorkerController;


    // constructors --------------------------------------------------------------------------------

    public WorkerView(Scanner scanner, IWorkerController iWorkerController) {
        this.scanner = scanner;
        this.iWorkerController = iWorkerController;
    }

    public void start() {
    }


}
