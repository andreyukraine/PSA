package ua.artcode.utils.init;

import ua.artcode.controler.*;
import ua.artcode.db.AppDBImpl;
import ua.artcode.exceptions.AppDbException;
import ua.artcode.model.Service;
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
        IClientController iClientController = new IClientCotrollerImp(appDB,dbFileHandler);
        IService iService = new ServiceImp(appDB,dbFileHandler);

        IWorkerController iWorkerController = new IWorkerControllerImp(appDB,dbFileHandler);
        ICompany iCompany = new CompanyImp(appDB, dbFileHandler);
        initData(iModeratorPSAController, iModeratorController, iClientController, iService, iWorkerController, iCompany);

        iBash.saveObjToFile(appDB, Constants.DB_PATH);
        try {
            iBash.saveObjToJSON(appDB, Constants.DB_PATH_JSON);
        } catch (AppDbException e) {
            e.printStackTrace();
        }
    }


    public static void initData(IModeratorPSAController iModeratorPSAController, IModeratorController iModeratorController,
                                IClientController iClientController,IService iService, IWorkerController iWorkerController, ICompany iCompany) {
        iModeratorPSAController.addModeratorPSA("Andrey", "m", "+380", "m", Constants.StatusClientRole.MODERATOR_PSA);
        iModeratorController.addModerator("Moderatro", "mc", "+380", "mc", Constants.StatusClientRole.MODERATOR);
        iModeratorController.addModerator("Moderatroq", "zaq", "+380", "zaq", Constants.StatusClientRole.MODERATOR);
        iClientController.addClient("Client", "c", "+380", "c", Constants.StatusClientRole.CLIENT);
        Service service = iService.addService("Service1", "Description");
        iWorkerController.addWorker("lll","0","ooo","0");

        iCompany.addCompany("Company", "DescComp", null, null, service);
        iCompany.addCompany("Company1", "DescComp1", null, null, service);


    }
}
