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
                addModeratorPSA();
            }
            if(choice == 2){

            }
            if(choice == 3){

            }
            if(choice == 4){

            }
            if(choice == 5){

            }
            if(choice == 6){
                addServiceMenu();
            }
            if (choice == 7){
                editServiceMenu();
            }
            if (choice == 8){
                removeService();
            }
            if (choice == 10){
                addClient();
            }
            showMainMenu();
        }
    }


    public void showMainMenu(){
        System.out.println("1.addModeratorPSA");
        System.out.println("6.addService");
        System.out.println("7.editService");
        System.out.println("8.removeService");
        System.out.println("9.chooseService");
        System.out.println("10.addClient");
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
        System.out.println(editService);
    }

    public void removeService(){
        System.out.println("Input service id");
        long serviceId = scanner.nextLong();

        String removeService = iModeratorPSAController.removeService(serviceId);;
        System.out.println(removeService);
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
        String roleUser = status.statusClientRole(4);
        Client client = iModeratorPSAController.addClient(fullnameClient,emailClient,phoneClient,passClient,roleUser);
    }

    public void addModeratorPSA(){
        System.out.println("Input ModeratorPSA fullname");
        String fullnameModeratorPSA = scanner.nextLine();
        System.out.println("Input ModeratorPSA email");
        String emailModeratorPSA = scanner.nextLine();
        System.out.println("Input ModeratorPSA phone");
        String phoneModeratorPSA = scanner.nextLine();
        System.out.println("Input ModeratorPSA pass");
        String passModeratorPSA = scanner.nextLine();

        Status status = new Status();
        String roleUser = status.statusClientRole(1);
        Client client = iModeratorPSAController.addClient(fullnameModeratorPSA,emailModeratorPSA,phoneModeratorPSA,passModeratorPSA,roleUser);

    }



    //get set-------------------------



}
