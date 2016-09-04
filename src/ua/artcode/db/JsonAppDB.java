package ua.artcode.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.artcode.model.ModeratorPSA;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by IT on 04.09.2016.
 */
public class JsonAppDB implements Ijson {


    @Override
    public void addModeratorPSAJson(IAppDB iAppDB) {
        try {
            Writer writer = new FileWriter("src/ua/artcode/package.json");
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            gson.toJson(iAppDB, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
