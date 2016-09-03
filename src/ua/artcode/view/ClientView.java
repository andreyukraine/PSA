package ua.artcode.view;

import ua.artcode.controler.IClientController;
import ua.artcode.db.IAppDB;
import ua.artcode.model.*;

import java.util.Scanner;

import static ua.artcode.run.RunProgramms.showStartMenu;

/**
 * Created by IT on 25.08.2016.
 */
public class ClientView {

    private Scanner scanner;
    private IClientController iClientController;
    private IAppDB iAppDB;
    private Client client;
    private Service serviceTemp = null;
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
            if (choice == 3){
                showStartMenu();
            }

        }
    }

    public void showMainMenu(){
        System.out.println("1. addCompany");
        System.out.println("2. searchServiceMenu()");
        System.out.println("-------------------------------------------");
        System.out.println("3. Exit");
    }

    public void addCompanyMenu(){
        System.out.println("Input nameCompany");
        String name = scanner.nextLine();
        System.out.println("Input descriptionCompany");
        String description = scanner.nextLine();
        Location location = new Location().setLocationMenu();

        Company company = iClientController.addCompany(name,description,client,location, null);
        iAppDB.addModeratorCompany(client, company);
    }

    public void searchServiceMenu() {
        System.out.println("Input nameService");
        String name = scanner.nextLine();

        System.out.println(iClientController.searchService(name));
    }

}
