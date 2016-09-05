package ua.artcode.view;

import ua.artcode.controler.IClientController;
import ua.artcode.model.Location;

import java.util.Scanner;

import static ua.artcode.run.RunProgram.showStartMenu;

/**
 * Created by IT on 25.08.2016.
 */
public class ClientView {

    private Scanner scanner;
    private IClientController iClientController;

    // constructors --------------------------------------------------------------------------------


    public ClientView(Scanner scanner, IClientController iClientController) {
        this.scanner = scanner;
        this.iClientController = iClientController;
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
        Location location = new Location().setLocationMenu(new Scanner(System.in));

        //Company company = iClientController.addCompany(name,description,client,location, null);
        //iAppDB.addModeratorCompany(client, company);
    }

    public void searchServiceMenu() {
        System.out.println("Input nameService");
        String name = scanner.nextLine();

        System.out.println(iClientController.searchService(name));
    }

}
