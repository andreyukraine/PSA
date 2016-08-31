package ua.artcode.view;

import ua.artcode.controler.IClientController;
import ua.artcode.controler.IModeratorController;
import ua.artcode.controler.IModeratorPSAController;
import ua.artcode.controler.IWorkerController;
import ua.artcode.model.Client;
import ua.artcode.model.Status;

import java.util.Scanner;

import static ua.artcode.run.RunProgramms.appDB;

/**
 * Created by IT on 25.08.2016.
 */



public class RegistrationCompanyView {

    Scanner scanner;
    IModeratorController iModeratorController;
    IModeratorPSAController iModeratorPSAController;
    IWorkerController iWorkerController;
    IClientController iClientController;


    public RegistrationCompanyView(Scanner scanner, IModeratorController iModeratorController,IModeratorPSAController iModeratorPSAController,
                                   IWorkerController iWorkerController, IClientController iClientController) {
        this.scanner = scanner;
        this.iModeratorController = iModeratorController;
        this.iModeratorPSAController = iModeratorPSAController;
        this.iWorkerController = iWorkerController;
        this.iClientController = iClientController;
    }

    public void start(){

        LoginView loginView = new LoginView(new Scanner(System.in),iModeratorPSAController,
                iModeratorController,iWorkerController, iClientController, appDB);


        showLoginOrNewClient();

        int choice = -1;
        while ((choice = Integer.parseInt(scanner.nextLine())) != 0) {
            if (choice == 1) {
                addClient();
                //addCompany
            }
            if (choice == 2) {


                if (loginView.showLoginMenu() == true){
                    //addCompany
                    loginView.showLoginMenu();
                };
            }
        }
    }

    private void showLoginOrNewClient() {
        System.out.println("1. Новый клиент?");
        System.out.println("2. Вы уже зарегестрированый как клиент сервиса?");
    }

    public void addClient(){
        System.out.println("Input client fullname");
        String fullnameClient = scanner.nextLine();
        System.out.println("Input client email");
        String emailClient = scanner.nextLine();
        System.out.println("Input client phone");
        String phoneClient = scanner.nextLine();
        System.out.println("Input client pass");
        String passClient = scanner.nextLine();

        Status status = new Status();
        String roleUser = status.statusUserRole(2);
        Client client = iModeratorPSAController.addClient(fullnameClient,emailClient,phoneClient,passClient,roleUser);
    }
}
