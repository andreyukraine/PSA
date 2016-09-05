package ua.artcode.utils.init;

import ua.artcode.controler.IModeratorController;
import ua.artcode.controler.IModeratorControllerImp;
import ua.artcode.controler.IModeratorPSAController;
import ua.artcode.controler.IModeratorPSAControllerImp;
import ua.artcode.db.AppDBImpl;
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
        IModeratorController iModeratorController = new IModeratorControllerImp(appDB,dbFileHandler);
        initData(iModeratorPSAController, iModeratorController);

        iBash.saveObjToFile(appDB, Constants.DB_PATH);
    }


    public static void initData(IModeratorPSAController iModeratorPSAController, IModeratorController iModeratorController) {
        iModeratorPSAController.addModeratorPSA("Andrey", "m", "+380", "m", Constants.statusClientRole.MODERATOR_PSA);
        iModeratorController.addModerator("Moderatro", "mc", "+380", "mc", Constants.statusClientRole.MODERATOR);
        iModeratorController.addModerator("Moderatroq", "zaq", "+380", "zaq", Constants.statusClientRole.MODERATOR);
        iModeratorPSAController.addClient("Client", "c", "+380", "c", Constants.statusClientRole.CLIENT);
        iModeratorController.addCompany("Company", "DescComp", null, null, null);
        iModeratorPSAController.addService("Service1", "Description");

    }
}
