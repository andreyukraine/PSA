package ua.artcode.controler;

import ua.artcode.db.AppDBImpl;
import ua.artcode.model.*;
import ua.artcode.utils.Constants;
import ua.artcode.utils.DBFileHandler;

/**
 * Created by IT on 21.08.2016.
 */
public class IModeratorControllerImp implements IModeratorController {

    private AppDBImpl appDB;
    private DBFileHandler dbFileHandler;

    public IModeratorControllerImp(AppDBImpl appDB, DBFileHandler dbFileHandler) {
        this.appDB = appDB;
        this.dbFileHandler = dbFileHandler;
    }

    @Override
    public Moderator addModerator(String fullname, String email, String phone, String pass, Constants.StatusClientRole role) {
        Moderator moderator= new Moderator(fullname, email, phone, pass, role, null);
        return appDB.addModerator(moderator);
    }

    @Override
    public Service addServiceToCompany(long companyId, long serviceId) {
        return null;
    }

    @Override
    public Company getCompanyModerator(int moderatroId) {
        return appDB.getCompanyModerator(moderatroId);
    }



}
