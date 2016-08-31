package ua.artcode.view;

import ua.artcode.controler.IModeratorController;

import java.util.Scanner;

/**
 * Created by IT on 25.08.2016.
 */
public class ModeratorView {

    Scanner scanner;
    IModeratorController iModeratorController;

    // constructors --------------------------------------------------------------------------------

    public ModeratorView(Scanner scanner, IModeratorController iModeratorController) {
        this.scanner = scanner;
        this.iModeratorController = iModeratorController;
    }




}
