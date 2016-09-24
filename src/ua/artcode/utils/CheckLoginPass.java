package ua.artcode.utils;

import ua.artcode.db.IAppDB;
import ua.artcode.model.Client;
import ua.artcode.model.Moderator;
import ua.artcode.model.ModeratorPSA;
import ua.artcode.model.User;

import java.util.Map;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by IT on 04.09.2016.
 */
public class CheckLoginPass {

    private String login;
    private String pass;
    private IAppDB iAppDB;
    private Scanner scanner;

    public CheckLoginPass() {
    }

    public CheckLoginPass(String login, String passw, IAppDB iAppDB, Scanner scanner) {
        this.login = login;
        this.pass = passw;
        this.iAppDB = iAppDB;
        this.scanner = scanner;
    }

    public static User CheckLoginPassw(String login, String pass, IAppDB iAppDB, Scanner scanner) {

        for (Map.Entry<String, ModeratorPSA> entry : iAppDB.getModeratorPSA().entrySet()){
            if (entry.getValue().getRole().equals(Constants.statusClientRole.MODERATOR_PSA) &&
                    entry.getValue().getEmail().equals(login) &&
                    entry.getValue().getPass().equals(pass)) {
                return entry.getValue();
            }
        }
        for (Map.Entry<String, Moderator> entry : iAppDB.getListModerator().entrySet()){
            if (entry.getValue().getRole().equals(Constants.statusClientRole.MODERATOR) &&
                    entry.getValue().getEmail().equals(login) &&
                    entry.getValue().getPass().equals(pass)) {
                return entry.getValue();
            }
        }
        for (Map.Entry<String, Client> entry : iAppDB.getListClients().entrySet()){
            if (entry.getValue().getRole().equals(Constants.statusClientRole.WORKER) &&
                    entry.getValue().getEmail().equals(login) &&
                    entry.getValue().getPass().equals(pass)){
                return entry.getValue();
            }
        }

        for (Map.Entry<String, Client> entry : iAppDB.getListClients().entrySet()){
            if (entry.getValue().getRole().equals(Constants.statusClientRole.CLIENT) &&
                    entry.getValue().getEmail().equals(login) &&
                    entry.getValue().getPass().equals(pass)){
                return entry.getValue();
            }
        }
//        for (int i = 0; i < iAppDB.getListClients().size(); i++) {
//
//            if (iAppDB.getListClients().get(i).getEmail().equals(login) && iAppDB.getListClients().get(i).getPass().equals(pass) &&
//                    iAppDB.getListClients().get(i).getRole().equals(Constants.statusClientRole.WORKER)) {
//                return iAppDB.getListClients().get(i);
//            }
//        }
//        for (int i = 0; i < iAppDB.getListClients().size(); i++) {
//            if (iAppDB.getListClients().get(i).getEmail().equals(login) && iAppDB.getListClients().get(i).getPass().equals(pass) &&
//                    iAppDB.getListClients().get(i).getRole().equals(Constants.statusClientRole.CLIENT)) {
//                return iAppDB.getListClients().get(i);
//            }
//        }


        return null;

    }
}
