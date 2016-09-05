package ua.artcode.view;

import ua.artcode.controler.IClientController;
import ua.artcode.controler.IModeratorController;
import ua.artcode.controler.IModeratorPSAController;
import ua.artcode.controler.IWorkerController;
import ua.artcode.db.IAppDB;
import ua.artcode.model.Status;
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
    private IAppDB iAppDB;



    // constructors --------------------------------------------------------------------------------

    public LoginView(Scanner scanner, IModeratorPSAController iModeratorPSAController,
                     IModeratorController iModeratorController, IWorkerController iWorkerController, IClientController iClientController, IAppDB appDB) {
        this.scanner = scanner;
        this.iModeratorPSAController = iModeratorPSAController;
        this.iModeratorController = iModeratorController;
        this.iClientController = iClientController;
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
            ModeratorPSAView moderatorPSAView = new ModeratorPSAView(scanner, iModeratorPSAController);
            moderatorPSAView.start();
        }else if (role.equals(Constants.statusClientRole.MODERATOR)){
            ModeratorView moderatorView = new ModeratorView(scanner, iModeratorController);
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
