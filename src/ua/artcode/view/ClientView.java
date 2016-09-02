package ua.artcode.view;

import ua.artcode.controler.IClientController;
import ua.artcode.db.IAppDB;
import ua.artcode.model.Client;
import ua.artcode.model.Company;
import ua.artcode.model.Location;
import ua.artcode.model.Status;

import java.util.Scanner;

/**
 * Created by IT on 25.08.2016.
 */
public class ClientView {

    private Scanner scanner;
    private IClientController iClientController;
    private IAppDB iAppDB;
    private Client client;
    // constructors --------------------------------------------------------------------------------


    public ClientView(Scanner scanner, IClientController iClientController, IAppDB iAppDB, Client client) {
        this.scanner = scanner;
        this.iClientController = iClientController;
        this.iAppDB = iAppDB;
        this.client = client;
    }

    public void start(){
        showMainMenu();
        int choice = -1;
        while ((choice = Integer.parseInt(scanner.nextLine())) != 0){

            if(choice == 1){
                addCompanyMenu();
            }
            if (choice == 2){
                searchServiceMenu();
            }

            showMainMenu();
        }
    }

    public void showMainMenu(){
        System.out.println("1. addCompany");
        System.out.println("2. searchServiceMenu()");
    }

    public void addCompanyMenu(){
        System.out.println("Input nameCompany");
        String name = scanner.nextLine();
        System.out.println("Input descriptionCompany");
        String description = scanner.nextLine();
        Location location = new Location().setLocationMenu(scanner);

        iClientController.addCompany(name,description,client,location);
        iAppDB.addModeratorCompany(client);
    }

    public void searchServiceMenu() {
        System.out.println("Input nameService");
        String name = scanner.nextLine();

        System.out.println(iClientController.searchService(name));
    }

}
