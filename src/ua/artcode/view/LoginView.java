package ua.artcode.view;

import ua.artcode.controler.*;
import ua.artcode.db.IAppDB;
import ua.artcode.run.RunProgram;
import ua.artcode.utils.CheckLoginPass;
import ua.artcode.utils.Constants;

import java.util.Scanner;


/**
 * Created by IT on 21.08.2016.
 */
public class LoginView {

    private Scanner scanner;
    private IModeratorPSAController iModeratorPSAController;
    private IModeratorController iModeratorController;
    private IWorkerController iWorkerController;
    private IClientController iClientController;
    private IService iService;
    private ICompany iCompany;
    private IAppDB iAppDB;



    // constructors --------------------------------------------------------------------------------

    public LoginView(Scanner scanner, IModeratorPSAController iModeratorPSAController,
                     IModeratorController iModeratorController, IWorkerController iWorkerController, IClientController iClientController, IService iService, ICompany iCompany, IAppDB appDB) {
        this.scanner = scanner;
        this.iModeratorPSAController = iModeratorPSAController;
        this.iModeratorController = iModeratorController;
        this.iClientController = iClientController;
        this.iService = iService;
        this.iCompany = iCompany;
        this.iWorkerController = iWorkerController;


        this.iAppDB = appDB;
    }

    // methods --------------------------------------------------------------------------------------

    public boolean showLoginMenu() {
        System.out.println("Input login");
        String login = scanner.nextLine();
        System.out.println("Input pass");
        String pass = scanner.nextLine();

        //Utils checkLoginPass = new Utils(login,pass);

        // check if user is in the system

        Constants.statusClientRole role = CheckLoginPass.CheckLoginPassw(login,pass,iAppDB,scanner);

        if (role.equals(Constants.statusClientRole.MODERATOR_PSA)){
            ModeratorPSAView moderatorPSAView = new ModeratorPSAView(scanner, iModeratorPSAController, iClientController, iService, iCompany, iWorkerController);
            moderatorPSAView.start();
        }else if (role.equals(Constants.statusClientRole.MODERATOR)){
            ModeratorView moderatorView = new ModeratorView(scanner, iModeratorController, iClientController,iService, iCompany, iWorkerController);
            moderatorView.start();
        }else if (role.equals(Constants.statusClientRole.WORKER)){
            WorkerView workerView = new WorkerView(scanner, iWorkerController);
            workerView.start();
        }else{
            ClientView clientView = new ClientView(scanner, iClientController);
            clientView.start();
        }


        RunProgram.showStartMenu();
        return false;
    }


}
