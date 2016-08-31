package ua.artcode.view;

import ua.artcode.controler.IClientController;

import java.util.Scanner;

/**
 * Created by IT on 25.08.2016.
 */
public class ClientView {

    Scanner scanner;
    IClientController iClientController;

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

            }


            showMainMenu();
        }
    }

    public void showMainMenu(){
        System.out.println("1.Register");


    }



}
