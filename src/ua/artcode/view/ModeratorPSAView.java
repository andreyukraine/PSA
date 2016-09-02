package ua.artcode.view;

import ua.artcode.controler.IModeratorPSAController;
import ua.artcode.db.IAppDB;
import ua.artcode.model.*;

import java.util.Scanner;

/**
 * Created by IT on 25.08.2016.
 */
public class ModeratorPSAView {

    private Scanner scanner;
    private IModeratorPSAController iModeratorPSAController;
    private IAppDB iAppDB;

    // constructors --------------------------------------------------------------------------------

    public ModeratorPSAView(Scanner scanner, IModeratorPSAController iModeratorPSAController, IAppDB iAppDB) {
        this.scanner = scanner;
        this.iModeratorPSAController = iModeratorPSAController;
        this.iAppDB = iAppDB;
    }

    // methods --------------------------------------------------------------------------------------

    public void start(){
        showMainMenu();
        int choice = -1;
        while ((choice = Integer.parseInt(scanner.nextLine())) != 0){
            if(choice == 1){
                addModeratorPSAMenu();
            }
            if(choice == 2){
                addServiceMenu();
            }
            if(choice == 3){
                changeStatusCompany();
            }
            if(choice == 4){
                editServiceMenu();
            }
            if(choice == 5){
                removeServiceMenu();
            }
            if(choice == 6){
                addClientMenu();
            }
            if (choice == 7){
                addCompanyMenu();
            }
            if (choice == 8){
                removeCompanyMenu();
            }
            if (choice == 9){
                removeClientMenu();
            }
            if (choice == 10){
                getListCompany();
            }
            if (choice == 11){
                getListClient();
            }
            if (choice == 12){
                getListServise();
            }
            showMainMenu();
        }
    }


    public void showMainMenu(){
        System.out.println("1. addModeratorPSA");
        System.out.println("2. addService");
        System.out.println("3. changeStatusCompany");
        System.out.println("4. editService");
        System.out.println("5. removeService");
        System.out.println("6. addClient");
        System.out.println("7. addCompany");
        System.out.println("8. removeCompany");
        System.out.println("9. removeClient");
        System.out.println("10. getListCompany");
        System.out.println("11. getListClient");
        System.out.println("12. getListServise");
    }



    public void changeStatusCompany(){
        System.out.println("Input company id");
        String companyId = scanner.nextLine();

        System.out.println("Input company status");
        String statusIndex = scanner.nextLine();

        iModeratorPSAController.changeStatusCompany(0,2);
    }

    public void addServiceMenu(){
        System.out.println("Input service name");
        String serviceName = scanner.nextLine();
        System.out.println("Input service description");
        String serviceDesc = scanner.nextLine();

        Service addService = iModeratorPSAController.addService(serviceName, serviceDesc);
        System.out.println(addService.toString());
    }

    public void editServiceMenu(){
        System.out.println("Input service id");
        String id = scanner.nextLine();
        long serviceId = Integer.parseInt(id);
        System.out.println("Input service new name");
        String serviceNewName = scanner.nextLine();
        System.out.println("Input service new description");
        String serviceNewDesc = scanner.nextLine();

        String editService = iModeratorPSAController.editService(serviceId,serviceNewName,serviceNewDesc);;
        System.out.println(editService.toString());
    }

    public void removeServiceMenu(){
        System.out.println("Input service id");
        long serviceId = scanner.nextLong();

        Service removeService = iModeratorPSAController.removeService(serviceId);
        System.out.println("Remove service: " + removeService.toString());
    }

    public void removeClientMenu(){
        System.out.println("Input client id");
        long clientId = scanner.nextLong();

        Client removeClient = iModeratorPSAController.removeClient(clientId);
        System.out.println("Remove client: " + removeClient.toString());
    }

    public void removeCompanyMenu(){
        System.out.println("Input company id");
        long companyId = scanner.nextLong();

        Company removeCompany = iModeratorPSAController.removeCompany(companyId);;
        System.out.println("Remove company: " + removeCompany.toString());
    }

    public void getListCompany(){
        System.out.println(iModeratorPSAController.listAllCompany().toString());
    }

    public void getListServise(){
        System.out.println(iModeratorPSAController.listAllService().toString());
    }

    public void getListClient(){
        System.out.println(iModeratorPSAController.listAllClient().toString());
    }

    public void addClientMenu(){
        System.out.println("Input client fullname");
        String fullname = scanner.nextLine();
        System.out.println("Input client email");
        String email = scanner.nextLine();
        System.out.println("Input client phone");
        String phone = scanner.nextLine();
        System.out.println("Input client pass");
        String pass = scanner.nextLine();

        Status status = new Status();
        String roleUser = status.statusClientRole(4);
        Client client = iModeratorPSAController.addClient(fullname,email,phone,pass,roleUser);
    }

    public void addModeratorPSAMenu(){
        System.out.println("Input ModeratorPSA fullname");
        String fullname = scanner.nextLine();
        System.out.println("Input ModeratorPSA email");
        String email = scanner.nextLine();
        System.out.println("Input ModeratorPSA phone");
        String phone = scanner.nextLine();
        System.out.println("Input ModeratorPSA pass");
        String pass = scanner.nextLine();

        Status status = new Status();
        String roleUser = status.statusClientRole(1);
        Client client = iModeratorPSAController.addClient(fullname,email,phone,pass,roleUser);

    }

    public void addCompanyMenu(){
        System.out.println("Input nameCompany");
        String name = scanner.nextLine();
        System.out.println("Input descriptionCompany");
        String description = scanner.nextLine();
        Location location = new Location().setLocationMenu(scanner);

        iModeratorPSAController.addCompany(name,description,null,location);
    }

    public void statusCompanyMenu(){
        System.out.println("Input company id");
        long companyId = scanner.nextLong();
        System.out.println("Input company statusIndex");
        int statusIndex = scanner.nextInt();

        Company company = iModeratorPSAController.changeStatusCompany(companyId,statusIndex);
        System.out.println(company.toString());
    }

}
