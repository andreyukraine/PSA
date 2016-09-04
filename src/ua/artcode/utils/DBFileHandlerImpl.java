package ua.artcode.utils;

import ua.artcode.db.AppDBImpl;
import ua.artcode.exceptions.AppDbException;

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
    public String exportToJson(AppDBImpl appDB) throws AppDbException {
        return null;
    }

    @Override
    public AppDBImpl importFromJson(String json) throws AppDbException {
        return null;
    }
}
