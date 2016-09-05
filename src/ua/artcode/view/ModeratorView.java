package ua.artcode.view;

import ua.artcode.controler.IModeratorController;
import ua.artcode.db.IAppDB;
import ua.artcode.model.Status;
import ua.artcode.model.Worker;

import java.util.Scanner;

import static ua.artcode.run.RunProgram.showStartMenu;

/**
 * Created by IT on 25.08.2016.
 */
public class ModeratorView {

    Scanner scanner;
    IModeratorController iModeratorController;

    // constructors --------------------------------------------------------------------------------

    public ModeratorView(Scanner scanner, IModeratorController iModeratorController) {
        this.scanner = scanner;
        this.iModeratorController = iModeratorController;
    }

    public void start(){
        showMainMenu();
        int choice = -1;
        while ((choice = Integer.parseInt(scanner.nextLine())) != 0){
            if(choice == 1){
                createWorkerMenu();
            }
            if (choice == 2){
                showStartMenu();
            }
        }
    }

    public void showMainMenu(){
        System.out.println("1. createWorker");
        System.out.println("2. Exit");
    }

    public void createWorkerMenu(){

            System.out.println("Input worker fullname");
            String fullname = scanner.nextLine();
            System.out.println("Input worker email");
            String email = scanner.nextLine();
            System.out.println("Input worker phone");
            String phone = scanner.nextLine();
            System.out.println("Input worker pass");
            String pass = scanner.nextLine();
            System.out.println("Input worker description");
            String desc = scanner.nextLine();

            iModeratorController.createWorker(fullname,email,phone,pass);

    }
}
