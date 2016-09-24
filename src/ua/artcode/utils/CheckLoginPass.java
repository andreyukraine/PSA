package ua.artcode.utils;

import ua.artcode.db.IAppDB;
import ua.artcode.model.Client;
import ua.artcode.model.Moderator;
import ua.artcode.model.ModeratorPSA;
import ua.artcode.model.User;

import java.util.Map;
import java.util.Scanner;

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
            if (entry.getValue().getRole().equals(Constants.StatusClientRole.MODERATOR_PSA) &&
                    entry.getValue().getEmail().equals(login) &&
                    entry.getValue().getPass().equals(pass)) {
                return entry.getValue();
            }
        }
        for (Map.Entry<String, Moderator> entry : iAppDB.getListModerator().entrySet()){
            if (entry.getValue().getRole().equals(Constants.StatusClientRole.MODERATOR) &&
                    entry.getValue().getEmail().equals(login) &&
                    entry.getValue().getPass().equals(pass)) {
                return entry.getValue();
            }
        }
        for (Map.Entry<String, Client> entry : iAppDB.getListClients().entrySet()){
            if (entry.getValue().getRole().equals(Constants.StatusClientRole.WORKER) &&
                    entry.getValue().getEmail().equals(login) &&
                    entry.getValue().getPass().equals(pass)){
                return entry.getValue();
            }
        }

        for (Map.Entry<String, Client> entry : iAppDB.getListClients().entrySet()){
            if (entry.getValue().getRole().equals(Constants.StatusClientRole.CLIENT) &&
                    entry.getValue().getEmail().equals(login) &&
                    entry.getValue().getPass().equals(pass)){
                return entry.getValue();
            }
        }
//        for (int i = 0; i < iAppDB.getListClients().size(); i++) {
//
//            if (iAppDB.getListClients().get(i).getEmail().equals(login) && iAppDB.getListClients().get(i).getPass().equals(pass) &&
//                    iAppDB.getListClients().get(i).getRole().equals(Constants.StatusClientRole.WORKER)) {
//                return iAppDB.getListClients().get(i);
//            }
//        }
//        for (int i = 0; i < iAppDB.getListClients().size(); i++) {
//            if (iAppDB.getListClients().get(i).getEmail().equals(login) && iAppDB.getListClients().get(i).getPass().equals(pass) &&
//                    iAppDB.getListClients().get(i).getRole().equals(Constants.StatusClientRole.CLIENT)) {
//                return iAppDB.getListClients().get(i);
//            }
//        }


        return null;

    }
}
