package ua.artcode.view;

import ua.artcode.controler.*;
import ua.artcode.utils.Constants;

import java.util.Scanner;
import static ua.artcode.run.RunProgram.showStartMenu;

/**
 * Created by IT on 25.08.2016.
 */
public class ModeratorView {

    Scanner scanner;
    IModeratorController iModeratorController;
    IClientController iClientController;
    IService iService;
    ICompany iCompany;
    IWorkerController iWorkerController;

    // constructors --------------------------------------------------------------------------------

    public ModeratorView(Scanner scanner, IModeratorController iModeratorController, IClientController iClientController, IService iService, ICompany iCompany, IWorkerController iWorkerController) {
        this.scanner = scanner;
        this.iModeratorController = iModeratorController;
        this.iClientController = iClientController;
        this.iService = iService;
        this.iCompany = iCompany;
        this.iWorkerController = iWorkerController;
    }

    public void start(){
        showMainMenu();
        int choice = -1;
        while ((choice = Integer.parseInt(scanner.nextLine())) != 0){
            if(choice == 1){
                addModeratorMenu();
            }else if (choice == 2){
                createWorkerMenu();
            }else if (choice == 3){
                showStartMenu();
            }

        }
    }

    public void showMainMenu(){
        System.out.println("1. addModerator");
        System.out.println("2. createWorker");
        System.out.println("3. Exit");
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

            iWorkerController.addWorker(fullname,email,phone,pass);
    }

    public void addModeratorMenu() {
        System.out.println("Input Moderator fullname");
        String fullname = scanner.nextLine();
        System.out.println("Input Moderator email");
        String email = scanner.nextLine();
        System.out.println("Input Moderator phone");
        String phone = scanner.nextLine();
        System.out.println("Input Moderator pass");
        String pass = scanner.nextLine();

        iModeratorController.addModerator(fullname, email, phone, pass, Constants.statusClientRole.MODERATOR_PSA);
    }
}
