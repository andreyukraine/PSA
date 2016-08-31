package ua.artcode.run;

import ua.artcode.controler.*;
import ua.artcode.db.AppDBImpl;
import ua.artcode.db.IAppDB;
import ua.artcode.model.Status;
import ua.artcode.view.LoginView;
import ua.artcode.view.RegistrationCompanyView;

import java.util.Scanner;

/**
 * Created by IT on 25.08.2016.
 */
public class RunProgramms {

    public static final IAppDB appDB = new AppDBImpl();

    public static void main(String[] args) {
        IModeratorPSAController iModeratorPSAController = new IModeratorPSAControllerImp();
        IModeratorController iModeratorController = new IModeratorControllerImp();
        IWorkerController iWorkerController = new IWorkerControllerImp();
        IClientController iClientController = new IClientCotrollerImp();
        iModeratorPSAController.addModeratorPSA("Andrey", "m", "+380", "m", new Status().statusClientRole(1));
        iModeratorPSAController.addClient("Client","c","+380","c",new Status().statusClientRole(4));

        showStartMenu();
        int choice = -1;
        while ((choice = Integer.parseInt(new Scanner(System.in).nextLine())) != 0) {
            if (choice == 1) {
                LoginView loginView =
                        new LoginView(new Scanner(System.in), iModeratorPSAController, iModeratorController, iWorkerController, iClientController, appDB);
                loginView.showLoginMenu();
            }
            if (choice == 2) {
                RegistrationCompanyView registrationCompanyView = new RegistrationCompanyView(new Scanner(System.in), iModeratorController, iModeratorPSAController,
                    iWorkerController, iClientController, appDB);
                registrationCompanyView.start();
            }
        }
    }


    private static void showStartMenu() {
        System.out.println("1.Registration");
        System.out.println("2.Add company");
    }

}

