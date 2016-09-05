package ua.artcode.utils;

import ua.artcode.db.IAppDB;

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

    public static Constants.statusClientRole CheckLoginPassw(String login,String pass,IAppDB iAppDB,Scanner scanner) {
        for (int i = 0; i < iAppDB.getModeratorPSA().size(); i++) {
            if (iAppDB.getModeratorPSA().get(i).getEmail().equals(login) && iAppDB.getModeratorPSA().get(i).getPass().equals(pass)
                    && iAppDB.getModeratorPSA().get(i).getRole().equals(Constants.statusClientRole.MODERATOR_PSA)) {
                return iAppDB.getModeratorPSA().get(i).getRole();
            }
        }
        for (int i = 0; i < iAppDB.getListModerator().size(); i++) {
            if (iAppDB.getListModerator().get(i).getEmail().equals(login) && iAppDB.getListModerator().get(i).getPass().equals(pass) &&
                    iAppDB.getListModerator().get(i).getRole().equals(Constants.statusClientRole.MODERATOR)) {
                return  iAppDB.getListModerator().get(i).getRole();
            }
        }
        for (int i = 0; i < iAppDB.getListClients().size(); i++) {
            if (iAppDB.getListClients().get(i).getEmail().equals(login) && iAppDB.getListClients().get(i).getPass().equals(pass) &&
                    iAppDB.getListClients().get(i).getRole().equals(Constants.statusClientRole.WORKER)) {
                return iAppDB.getListClients().get(i).getRole();
            }
        }
        for (int i = 0; i < iAppDB.getListClients().size(); i++) {
            if (iAppDB.getListClients().get(i).getEmail().equals(login) && iAppDB.getListClients().get(i).getPass().equals(pass) &&
                    iAppDB.getListClients().get(i).getRole().equals(Constants.statusClientRole.CLIENT)) {
                return iAppDB.getListClients().get(i).getRole();
            }
        }
        return null;
    }
}
