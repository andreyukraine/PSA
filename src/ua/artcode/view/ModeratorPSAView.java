package ua.artcode.view;

import ua.artcode.controler.*;
import ua.artcode.exceptions.AppException;
import ua.artcode.model.*;
import ua.artcode.utils.Constants;

import java.util.Scanner;

import static ua.artcode.run.RunProgram.*;

/**
 * Created by IT on 25.08.2016.
 */
public class ModeratorPSAView {

    private Scanner scanner;
    private IModeratorPSAController iModeratorPSAController;
    private IClientController iClientController;
    private IService iService;
    private ICompany iCompany;
    private IWorkerController iWorkerController;
    // constructors --------------------------------------------------------------------------------

    public ModeratorPSAView(Scanner scanner, IModeratorPSAController iModeratorPSAController, IClientController iClientController, IService iService, ICompany iCompany, IWorkerController iWorkerController) {
        this.scanner = scanner;
        this.iModeratorPSAController = iModeratorPSAController;
        this.iClientController = iClientController;
        this.iService = iService;
        this.iCompany = iCompany;
        this.iWorkerController = iWorkerController;
    }

    // methods --------------------------------------------------------------------------------------

    public void start() {
        showMainMenu();
        int choice = -1;
        while ((choice = Integer.parseInt(scanner.nextLine())) != 0) {
            if (choice == 1) {
                addModeratorPSAMenu();
            } else if (choice == 2) {
                addServiceMenu();
            } else if (choice == 3) {
                removeServiceMenu();
            } else if (choice == 4) {
                editServiceMenu();
            } else if (choice == 5) {
                changeStatusCompany();
            } else if (choice == 6) {
                addCompanyMenu();
            } else if (choice == 7) {
                removeCompanyMenu();
            } else if (choice == 8) {
                addClientMenu();
                break;
            } else if (choice == 9) {
                removeClientMenu();
            } else if (choice == 10) {
                getListCompany();
            } else if (choice == 11) {
                getListClient();
            } else if (choice == 12) {
                getListServise();
            } else if (choice == 13) {
                showDbAsJsonMenu();
            } else if (choice == 14) {
                saveAllToDbMenu();
            } else if (choice == 15) {
                //showStartMenu();
            }

        }
        return;
    }

    private void saveAllToDbMenu() {
        try {
            iModeratorPSAController.saveAllToDb();
        } catch (AppException e) {
            e.printStackTrace();
        }
    }

    private void showDbAsJsonMenu() {
        try {
            String json = iModeratorPSAController.dbToJson();
            System.out.println(json);
        } catch (AppException e) {
            e.printStackTrace();
        }
    }


    public void showMainMenu() {
        System.out.println("1. addModeratorPSA");
        System.out.println("2. addService");
        System.out.println("3. removeService");
        System.out.println("4. editService");
        System.out.println("5. changeStatusCompany");
        System.out.println("6. addCompany");
        System.out.println("7. removeCompany");
        System.out.println("8. addClient");
        System.out.println("9. removeClient");





        System.out.println("10. getListCompany");
        System.out.println("11. getListClient");
        System.out.println("12. getListServise");
        System.out.println("13. json");
        System.out.println("14. save All");
        System.out.println("---------------------------------------------");
        System.out.println("15. Exit");
    }


    public void changeStatusCompany() {
        System.out.println("Input company name");
        String companyName = scanner.nextLine();

        System.out.println("Input company status");

        String statusIndex = scanner.nextLine();

        iCompany.changeStatusCompany(companyName, Constants.statusCompany.DONE);
    }

    public void addServiceMenu() {
        System.out.println("Input service name");
        String serviceName = scanner.nextLine();
        System.out.println("Input service description");
        String serviceDesc = scanner.nextLine();

        Service addService = iService.addService(serviceName, serviceDesc);
        System.out.println(addService.toString());
    }

    public void editServiceMenu() {
        System.out.println("Input service id");
        String id = scanner.nextLine();
        long serviceId = Integer.parseInt(id);
        System.out.println("Input service new name");
        String serviceNewName = scanner.nextLine();
        System.out.println("Input service new description");
        String serviceNewDesc = scanner.nextLine();

        Service editService = iService.editService(serviceId, serviceNewName, serviceNewDesc);
        System.out.println(editService.toString());
    }

    public void removeServiceMenu() {
        System.out.println("Input service id");
        long serviceId = scanner.nextLong();

        Service removeService = iService.rmServiceFromApp(serviceId);
        System.out.println("Remove service: " + removeService.toString());
    }

    public void removeClientMenu() {
        System.out.println("Input client id");
        long clientId = scanner.nextLong();

        Client removeClient = iClientController.removeClient(clientId);
        System.out.println("Remove client: " + removeClient.toString());
    }

    public void removeCompanyMenu() {
        System.out.println(iCompany.listAllCompany().toString());
        System.out.println("Input company id");
        long companyId = scanner.nextLong();
        Company removeCompany = iCompany.removeCompany(companyId);

        System.out.println("Remove company: " + removeCompany.toString());
    }

    public void getListCompany() {
        System.out.println(iCompany.listAllCompany().toString());
    }

    public void getListServise() {
        System.out.println(iService.getAllServicesApp().toString());
    }

    public void getListClient() {
        System.out.println(iClientController.listAllClient().toString());
    }

    public void addClientMenu() {
        System.out.println("Input client fullname");
        String fullname = scanner.nextLine();
        System.out.println("Input client email");
        String email = scanner.nextLine();
        System.out.println("Input client phone");
        String phone = scanner.nextLine();
        System.out.println("Input client pass");
        String pass = scanner.nextLine();

        iClientController.addClient(fullname, email, phone, pass, Constants.statusClientRole.CLIENT);
    }

    public void addModeratorPSAMenu() {
        System.out.println("Input ModeratorPSA fullname");
        String fullname = scanner.nextLine();
        System.out.println("Input ModeratorPSA email");
        String email = scanner.nextLine();
        System.out.println("Input ModeratorPSA phone");
        String phone = scanner.nextLine();
        System.out.println("Input ModeratorPSA pass");
        String pass = scanner.nextLine();

        iModeratorPSAController.addModeratorPSA(fullname, email, phone, pass, Constants.statusClientRole.MODERATOR_PSA);
    }

    public void addCompanyMenu() {
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

    public void statusCompanyMenu() {
        System.out.println("Input company name");
        String companyName = scanner.nextLine();
        System.out.println("Input company statusIndex");
        int statusIndex = scanner.nextInt();

        Company company = iCompany.changeStatusCompany(companyName, Constants.statusCompany.NEW);
        System.out.println(company.toString());
    }

}
