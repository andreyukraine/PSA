package ua.artcode.view;

import ua.artcode.controler.*;
import ua.artcode.db.IAppDB;
import ua.artcode.model.*;
import ua.artcode.utils.Constants;

import java.util.Scanner;



/**
 * Created by IT on 25.08.2016.
 */


public class RegistrationCompanyView {

    Scanner scanner;
    IModeratorController iModeratorController;
    IModeratorPSAController iModeratorPSAController;
    IWorkerController iWorkerController;
    IClientController iClientController;
    IService iService;
    ICompany iCompany;
    IAppDB iAppDB;
    Client clientTemp = null;
    Service serviceTemp = null;
    LoginView loginView;



    public RegistrationCompanyView(Scanner scanner, IModeratorController iModeratorController, IModeratorPSAController iModeratorPSAController,
                                   IWorkerController iWorkerController, IClientController iClientController, IAppDB iAppDB,IService iService, ICompany iCompany, LoginView loginView) {
        this.loginView = loginView;
        this.scanner = scanner;
        this.iModeratorController = iModeratorController;
        this.iModeratorPSAController = iModeratorPSAController;
        this.iWorkerController = iWorkerController;
        this.iClientController = iClientController;
        this.iService = iService;
        this.iCompany = iCompany;
        this.iAppDB = iAppDB;
    }

// тут добавить возврат менюшки как модератора
    public void start() {
        showLoginOrNewClient();
        int choice = -1;
        while ((choice = Integer.parseInt(scanner.nextLine())) != 0) {
            if (choice == 1) {
                addClient();
                System.out.println("-------------------------------");
                searchServiceMenu();
                System.out.println("--------------------------------");
                addCompanyMenu();

            }
            if (choice == 2) {
                if (loginView.showLoginMenu() == true) {
                    addCompanyMenu();
                }
            }
        }
    }

    private void showLoginOrNewClient() {
        System.out.println("1. Новый клиент?");
        System.out.println("2. Вы уже зарегестрированый как клиент сервиса?");
    }

    public void addClient() {
        System.out.println("Input client fullname");
        String fullnameClient = scanner.nextLine();
        System.out.println("Input client email");
        String emailClient = scanner.nextLine();
        System.out.println("Input client phone");
        String phoneClient = scanner.nextLine();
        System.out.println("Input client pass");
        String passClient = scanner.nextLine();

        clientTemp = iClientController.addClient(fullnameClient, emailClient, phoneClient, passClient, Constants.statusClientRole.MODERATOR);
    }

    public void addCompanyMenu(){
        System.out.println("Input nameCompany");
        String name = scanner.nextLine();
        System.out.println("Input descriptionCompany");
        String description = scanner.nextLine();
        Location location = new Location().setLocationMenu(new Scanner(System.in));
        System.out.println(iService.getAllServicesApp().toString());
        System.out.println("Input serviceId");
        int serviceId = Integer.parseInt(scanner.nextLine());

        Company company = iCompany.addCompany(name, description, null, location, null);
        iService.addServiceToCompany(company, iService.setService(serviceId));
    }

    public void searchServiceMenu() {
        System.out.println("Input nameService");
        System.out.println(iService.getAllServicesApp().toString());
        System.out.println("Input service ID");
        int serviceId = Integer.parseInt(scanner.nextLine());
        serviceTemp = iClientController.inputService(serviceId);

    }



}
