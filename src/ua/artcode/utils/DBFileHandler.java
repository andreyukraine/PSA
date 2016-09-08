package ua.artcode.utils;

import ua.artcode.db.AppDBImpl;
import ua.artcode.exceptions.AppDbException;

import java.io.IOException;

/**
 * Created by serhii on 04.09.16.
 */
public interface DBFileHandler {

    void save(AppDBImpl appDB) throws AppDbException;

    AppDBImpl load() throws AppDbException;

    String exportToJson(AppDBImpl appDB) throws AppDbException;

    AppDBImpl importFromJson() throws AppDbException;


}
