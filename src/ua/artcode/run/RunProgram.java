package ua.artcode.run;

import ua.artcode.controler.*;
import ua.artcode.db.AppDBImpl;
import ua.artcode.exceptions.AppDbException;
import ua.artcode.model.Client;
import ua.artcode.model.Moderator;
import ua.artcode.model.Worker;
import ua.artcode.utils.*;
import ua.artcode.view.LoginView;
import ua.artcode.view.RegistrationCompanyView;
import ua.artcode.view.swing.Authorization;
import ua.artcode.view.swing.LoginDialog;
import ua.artcode.view.swing.MainFrame;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by IT on 25.08.2016.
 */
public class RunProgram {

    public static void main(String[] args) throws AppDbException {


            DBFileHandler dbFileHandler = new DBFileHandlerImpl(Constants.DB_PATH,new IBashImpl());
            AppDBImpl appDB = dbFileHandler.load();

           // ICheckAuthorization iCheckAuthorization = new ICheckAuthorizationImp(appDB,dbFileHandler);
            IModeratorPSAController iModeratorPSAController = new IModeratorPSAControllerImp(appDB, dbFileHandler);
            IModeratorController iModeratorController = new IModeratorControllerImp(appDB, dbFileHandler);
            IWorkerController iWorkerController = new IWorkerControllerImp(appDB, dbFileHandler);
            IClientController iClientController = new IClientCotrollerImp(appDB, dbFileHandler);
            IService iService = new ServiceImp(appDB, dbFileHandler);
            ICompany iCompany = new CompanyImp(appDB, dbFileHandler);

            LoginView loginView =
                    new LoginView(new Scanner(System.in), iModeratorPSAController, iModeratorController, iWorkerController, iClientController, iService, iCompany, appDB);


            //showStartMenu();

            new LoginDialog(new JFrame(), loginView, iClientController, iModeratorPSAController, iWorkerController, iModeratorController);

//            int choice = -1;
//            while ((choice = Integer.parseInt(new Scanner(System.in).nextLine())) != 0) {
//                if (choice == 1) {
//                   // loginView.showLoginMenu();
//                }
//                if (choice == 2) {
//                    RegistrationCompanyView registrationCompanyView = new RegistrationCompanyView(new Scanner(System.in), iModeratorController, iModeratorPSAController,
//                            iWorkerController, iClientController, appDB, iService, iCompany, loginView);
//                    registrationCompanyView.start();
//                }
//            }
        }


    }




//    public static void showStartMenu() {
//        System.out.println("1. Authorization");
//        System.out.println("2. Add company");
//    }

//    public static void showStartBDMenu() {
//        System.out.println("Загрузить базу какую?");
//        System.out.println("1. File");
//        System.out.println("2. JSON");
//    }



