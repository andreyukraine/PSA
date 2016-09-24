package ua.artcode.view;

import ua.artcode.controler.*;
import ua.artcode.db.IAppDB;
import ua.artcode.model.Client;
import ua.artcode.model.User;
import ua.artcode.run.RunProgram;
import ua.artcode.utils.CheckLoginPass;
import ua.artcode.utils.Constants;
import ua.artcode.view.swing.Authorization;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


/**
 * Created by IT on 21.08.2016.
 */
public class LoginView {

    private Scanner scanner;
    private ICheckAuthorization iCheckAuthorization;
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
        this.iCheckAuthorization = iCheckAuthorization;
        this.iModeratorPSAController = iModeratorPSAController;
        this.iModeratorController = iModeratorController;
        this.iClientController = iClientController;
        this.iService = iService;
        this.iCompany = iCompany;
        this.iWorkerController = iWorkerController;
        this.iAppDB = appDB;
    }

    // methods --------------------------------------------------------------------------------------

    public User showLoginMenu(String login, String pass) {

        User user = CheckLoginPass.CheckLoginPassw(login, pass, iAppDB, scanner);
        if (user != null) {
            //iCheckAuthorization.addKeyAutorization(user);
            return user;
        }else{
            return null;
        }
    }


}
