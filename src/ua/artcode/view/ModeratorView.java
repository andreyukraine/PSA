package ua.artcode.view;

import ua.artcode.controler.IModeratorController;
import ua.artcode.db.IAppDB;

import java.util.Scanner;

/**
 * Created by IT on 25.08.2016.
 */
public class ModeratorView {

    Scanner scanner;
    IModeratorController iModeratorController;
    IAppDB iAppDB;

    // constructors --------------------------------------------------------------------------------

    public ModeratorView(Scanner scanner, IModeratorController iModeratorController, IAppDB iAppDB) {
        this.scanner = scanner;
        this.iModeratorController = iModeratorController;
        this.iAppDB = iAppDB;
    }




}
