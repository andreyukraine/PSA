package ua.artcode.utils;

import ua.artcode.db.AppDBImpl;
import ua.artcode.exceptions.AppDbException;

import java.io.IOException;


/**
 * Created by serhii on 04.09.16.
 */
public class DBFileHandlerImpl implements DBFileHandler {

    private String path;
    private IBash bash;

    public DBFileHandlerImpl(String path, IBash bash) {
        this.bash = bash;
        this.path = path;
    }

    @Override
    public void save(AppDBImpl appDB) throws AppDbException {
        bash.saveObjToFile(appDB, path);
    }

    @Override
    public AppDBImpl load() throws AppDbException {
        AppDBImpl appDB = (AppDBImpl) bash.loadObjFromFile(path);
        return appDB;
    }

    @Override
    public String exportToJson(AppDBImpl appDB) throws AppDbException{
        try {
            return bash.saveObjToJSON(appDB,path);
        } catch (AppDbException e) {
            e.printStackTrace();
        }
        return "dd";
    }

    @Override
    public AppDBImpl importFromJson() throws AppDbException {
        AppDBImpl appDB = (AppDBImpl) bash.loadObjFromJSON(path);
        return appDB;
    }
}
