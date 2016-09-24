package ua.artcode.controler;

import ua.artcode.db.AppDBImpl;
import ua.artcode.exceptions.AppException;
import ua.artcode.exceptions.ModeratorExeption;
import ua.artcode.model.*;
import ua.artcode.utils.Constants;
import ua.artcode.utils.DBFileHandler;

import java.util.List;
import java.util.Map;


/**
 * Created by IT on 22.08.2016.
 */
public class IModeratorPSAControllerImp implements IModeratorPSAController {

    private AppDBImpl appDB;
    private DBFileHandler dbFileHandler;

    public IModeratorPSAControllerImp() {
    }

    public IModeratorPSAControllerImp(AppDBImpl appDB, DBFileHandler dbFileHandler) {
        this.appDB = appDB;
        this.dbFileHandler = dbFileHandler;
    }

    @Override
    public ModeratorPSA addModeratorPSA(String fullname, String email, String phone, String pass, Constants.statusClientRole role) {
        ModeratorPSA moderatorPSA = new ModeratorPSA(fullname, email, phone, pass, role);
        return appDB.addModeratorPSA(moderatorPSA);
    }

    @Override
    public Map<String, Moderator> listAllModerator() throws ModeratorExeption {
        return appDB.getListModerator();
    }

    @Override
    public Location addLocation(String country, String city) {
        Location location = new Location(country, city);
        return appDB.addLocation(location);
    }

    @Override
    public void saveAllToDb() throws AppException {
        dbFileHandler.save(appDB);
    }

    @Override
    public void loadAllFromDb() throws AppException {
        appDB = dbFileHandler.load();
    }

    @Override
    public String dbToJson() throws AppException {
        return dbFileHandler.exportToJson(appDB);
    }
}
