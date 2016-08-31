package ua.artcode.view;

import ua.artcode.controler.IWorkerController;

import java.util.Scanner;

/**
 * Created by IT on 25.08.2016.
 */
public class WorkerView {

    Scanner scanner;
    IWorkerController iWorkerController;


    // constructors --------------------------------------------------------------------------------

    public WorkerView(Scanner scanner, IWorkerController iWorkerController) {
        this.scanner = scanner;
        this.iWorkerController = iWorkerController;
    }



}
