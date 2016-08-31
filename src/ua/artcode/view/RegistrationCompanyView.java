package ua.artcode.view;

import ua.artcode.controler.IClientController;
import ua.artcode.controler.IModeratorController;
import ua.artcode.controler.IModeratorPSAController;
import ua.artcode.controler.IWorkerController;
import ua.artcode.db.IAppDB;
import ua.artcode.model.*;

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
    IAppDB iAppDB;
    Client clientTemp = null;

    public RegistrationCompanyView(Scanner scanner, IModeratorController iModeratorController, IModeratorPSAController iModeratorPSAController,
                                   IWorkerController iWorkerController, IClientController iClientController, IAppDB iAppDB) {
        this.scanner = scanner;
        this.iModeratorController = iModeratorController;
        this.iModeratorPSAController = iModeratorPSAController;
        this.iWorkerController = iWorkerController;
        this.iClientController = iClientController;
        this.iAppDB = iAppDB;
    }

    public void start(){

        LoginView loginView = new LoginView(new Scanner(System.in),iModeratorPSAController,
                iModeratorController,iWorkerController, iClientController, appDB);


        showLoginOrNewClient();

        int choice = -1;
        while ((choice = Integer.parseInt(scanner.nextLine())) != 0) {
            if (choice == 1) {
                addClient();
                addCompany();
            }
            if (choice == 2) {


                if (loginView.showLoginMenu() == true){
                    addCompany();

                }else{
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
        String roleUser = status.statusClientRole(2);
        clientTemp = iModeratorPSAController.addClient(fullnameClient,emailClient,phoneClient,passClient,roleUser);
    }

    public void addCompany(){
        System.out.println("Input nameCompany");
        String nameCompany = scanner.nextLine();
        System.out.println("Input descriptionCompany");
        String descriptionCompany = scanner.nextLine();
        Location location = new Location().setLocationMenu(scanner);

        Status status = new Status();
        String changeStatusCompany = status.statusCompany(1);
        Company company = iClientController.addCompany(nameCompany,descriptionCompany,null,location);
    }




}
