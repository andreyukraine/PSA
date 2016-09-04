package ua.artcode.view;

import ua.artcode.controler.IClientController;
import ua.artcode.controler.IModeratorController;
import ua.artcode.controler.IModeratorPSAController;
import ua.artcode.controler.IWorkerController;
import ua.artcode.db.IAppDB;
import ua.artcode.model.*;

import java.util.Scanner;

import static ua.artcode.run.RunProgramms.appDB;
import static ua.artcode.run.RunProgramms.appJSON;

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
    Service serviceTemp = null;

    public RegistrationCompanyView(Scanner scanner, IModeratorController iModeratorController, IModeratorPSAController iModeratorPSAController,
                                   IWorkerController iWorkerController, IClientController iClientController, IAppDB iAppDB) {
        this.scanner = scanner;
        this.iModeratorController = iModeratorController;
        this.iModeratorPSAController = iModeratorPSAController;
        this.iWorkerController = iWorkerController;
        this.iClientController = iClientController;
        this.iAppDB = iAppDB;
    }

    LoginView loginView = new LoginView(new Scanner(System.in), iModeratorPSAController,
            iModeratorController, iWorkerController, iClientController, appDB, appJSON);

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
                addCompany();

                ModeratorView moderatorView = new ModeratorView(scanner, iModeratorController, iAppDB);
                moderatorView.start();


            }
            if (choice == 2) {
                if (loginView.showLoginMenu() == true) {
                    addCompany();
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


        String roleUser = Status.statusClientRole(2);
        clientTemp = iModeratorPSAController.addClient(fullnameClient, emailClient, phoneClient, passClient, roleUser);
    }

    public void searchServiceMenu() {
        System.out.println("Input nameService");
        String name = scanner.nextLine();
            System.out.println(iClientController.searchService(name));
            System.out.println("Input service ID");
            int serviceId = Integer.parseInt(scanner.nextLine());
            serviceTemp = iClientController.inputService(serviceId);

    }

    public void addCompany() {
        System.out.println("Input nameCompany");
        String nameCompany = scanner.nextLine();
        System.out.println("Input descriptionCompany");
        String descriptionCompany = scanner.nextLine();
        Location location = new Location().setLocationMenu(new Scanner(System.in));

        Company company = iClientController.addCompany(nameCompany, descriptionCompany, null, location, null);
        iAppDB.addServiceCompany(serviceTemp, nameCompany);
        iAppDB.addModeratorCompany(clientTemp, company);
    }

}
