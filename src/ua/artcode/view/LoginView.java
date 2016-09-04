package ua.artcode.view;

import ua.artcode.controler.IClientController;
import ua.artcode.controler.IModeratorController;
import ua.artcode.controler.IModeratorPSAController;
import ua.artcode.controler.IWorkerController;
import ua.artcode.db.IAppDB;
import ua.artcode.db.Ijson;
import ua.artcode.db.JsonAppDB;
import ua.artcode.model.Status;
import ua.artcode.run.RunProgramms;

import java.util.Scanner;

import static ua.artcode.run.RunProgramms.appJSON;
import static ua.artcode.run.RunProgramms.showStartMenu;

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
    private Ijson ijson;


    // constructors --------------------------------------------------------------------------------

    public LoginView(Scanner scanner, IModeratorPSAController iModeratorPSAController,
                     IModeratorController iModeratorController, IWorkerController iWorkerController, IClientController iClientController, IAppDB appDB, Ijson ijson) {
        this.scanner = scanner;
        this.iModeratorPSAController = iModeratorPSAController;
        this.iModeratorController = iModeratorController;
        this.iClientController = iClientController;
        this.iAppDB = appDB;
        this.ijson = ijson;
    }

    // methods --------------------------------------------------------------------------------------

    public boolean showLoginMenu() {
        System.out.println("Input login");
        String login = scanner.nextLine();
        System.out.println("Input pass");
        String pass = scanner.nextLine();

        //Utils checkLoginPass = new Utils(login,pass);

        // check if user is in the system

        for (int i = 0; i < iAppDB.getModeratorPSA().size() ; i++) {
            if (iAppDB.getModeratorPSA().get(i).getEmail().equals(login) && iAppDB.getModeratorPSA().get(i).getPass().equals(pass)
                    && iAppDB.getModeratorPSA().get(i).getRole().equals(new Status().statusClientRole(1))){
                ModeratorPSAView moderatorPSAView = new ModeratorPSAView(scanner,iModeratorPSAController,iAppDB, appJSON);
                moderatorPSAView.start();
                return true;
            }
        }
        for (int i = 0; i < iAppDB.getListModerator().size(); i++) {
            if (iAppDB.getListModerator().get(i).getEmail().equals(login) && iAppDB.getListModerator().get(i).getPass().equals(pass) &&
                    iAppDB.getListModerator().get(i).getRole().equals(new Status().statusClientRole(2))){
                ModeratorView moderatorView = new ModeratorView(scanner, iModeratorController, iAppDB);
                RunProgramms.MODERATOR_LOGIN = iAppDB.getListModerator().get(i);
                moderatorView.start();
                return true;
            }
        }
        for (int i = 0; i < iAppDB.getListClients().size(); i++) {
            if (iAppDB.getListClients().get(i).getEmail().equals(login) && iAppDB.getListClients().get(i).getPass().equals(pass) &&
                    iAppDB.getListClients().get(i).getRole().equals(new Status().statusClientRole(3))){
                WorkerView workerView = new WorkerView(scanner, iWorkerController, iAppDB);
                return true;
            }
        }
        for (int i = 0; i < iAppDB.getListClients().size(); i++) {
            if (iAppDB.getListClients().get(i).getEmail().equals(login) && iAppDB.getListClients().get(i).getPass().equals(pass) &&
                    iAppDB.getListClients().get(i).getRole().equals(new Status().statusClientRole(4))){
                ClientView clientView = new ClientView(scanner, iClientController, iAppDB, iAppDB.getListClients().get(i));
                clientView.start();
                return true;
            }
        }
        RunProgramms.showStartMenu();
        return false;
    }


}
