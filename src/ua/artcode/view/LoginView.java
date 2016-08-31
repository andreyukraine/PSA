package ua.artcode.view;

import ua.artcode.controler.IClientController;
import ua.artcode.controler.IModeratorController;
import ua.artcode.controler.IModeratorPSAController;
import ua.artcode.controler.IWorkerController;
import ua.artcode.db.IAppDB;
import ua.artcode.model.Status;
import ua.artcode.run.RunProgramms;
import ua.artcode.utils.Utils;

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

        for (int i = 0; i < iAppDB.getListModeratorPSA().size() ; i++) {
            if (iAppDB.getListModeratorPSA().get(i).getEmail().equals(login) && iAppDB.getListModeratorPSA().get(i).getPass().equals(pass)
                    && iAppDB.getListModeratorPSA().get(i).getRole().equals(new Status().statusUserRole(1))){
                ModeratorPSAView moderatorPSAView = new ModeratorPSAView(scanner,iModeratorPSAController,iAppDB);
                moderatorPSAView.start();
                return true;
            }
        }
        for (int i = 0; i < iAppDB.getListModerator().size(); i++) {
            if (iAppDB.getListModerator().get(i).getEmail().equals(login) && iAppDB.getListModerator().get(i).getPass().equals(pass) &&
                    iAppDB.getListModerator().get(i).getRole().equals(new Status().statusUserRole(2))){
                ModeratorView moderatorView = new ModeratorView(scanner, iModeratorController);
                return true;
            }
        }
        for (int i = 0; i < iAppDB.getListClients().size(); i++) {
            if (iAppDB.getListClients().get(i).getEmail().equals(login) && iAppDB.getListClients().get(i).getPass().equals(pass) &&
                    iAppDB.getListClients().get(i).getRole().equals(new Status().statusUserRole(3))){
                WorkerView workerView = new WorkerView(scanner, iWorkerController);
                return true;
            }
        }
        for (int i = 0; i < iAppDB.getListClients().size(); i++) {
            if (iAppDB.getListClients().get(i).getEmail().equals(login) && iAppDB.getListClients().get(i).getPass().equals(pass) &&
                    iAppDB.getListClients().get(i).getRole().equals(new Status().statusUserRole(4))){
                ClientView clientView = new ClientView(scanner, iClientController);
                clientView.start();
                return true;
            }
        }

        return false;
    }


}
