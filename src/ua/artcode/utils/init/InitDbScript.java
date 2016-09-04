package ua.artcode.utils.init;

import ua.artcode.controler.*;
import ua.artcode.db.AppDBImpl;
import ua.artcode.model.Status;
import ua.artcode.run.RunProgram;
import ua.artcode.utils.Constants;
import ua.artcode.utils.DBFileHandlerImpl;
import ua.artcode.utils.IBash;
import ua.artcode.utils.IBashImpl;

/**
 * Created by serhii on 04.09.16.
 */
public class InitDbScript {

    public static void main(String[] args) {
        AppDBImpl appDB = new AppDBImpl();
        IBash iBash = new IBashImpl();

        DBFileHandlerImpl dbFileHandler = new DBFileHandlerImpl(Constants.DB_PATH, iBash);
        IModeratorPSAController iModeratorPSAController =
                new IModeratorPSAControllerImp(appDB, dbFileHandler);
        IModeratorController iModeratorController = new IModeratorControllerImp(appDB);
        initData(iModeratorPSAController, iModeratorController);

        iBash.saveObjToFile(appDB, Constants.DB_PATH);
    }


    public static void initData(IModeratorPSAController iModeratorPSAController, IModeratorController iModeratorController) {
        iModeratorPSAController.addModeratorPSA("Andrey", "m", "+380", "m", new Status().statusClientRole(1));
        iModeratorController.addModerator("Moderatro", "mc", "+380", "mc", new Status().statusClientRole(2));
        iModeratorController.addModerator("Moderatroq", "zaq", "+380", "zaq", new Status().statusClientRole(2));
        iModeratorPSAController.addClient("Client", "c", "+380", "c", new Status().statusClientRole(4));
        iModeratorController.addCompany("Company", "DescComp", null, null, null);
        iModeratorPSAController.addService("Service1", "Description");

    }
}
