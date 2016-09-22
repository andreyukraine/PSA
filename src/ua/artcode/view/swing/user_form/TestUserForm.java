package ua.artcode.view.swing.user_form;

import ua.artcode.model.User;
import ua.artcode.utils.Constants;

/**
 * Created by lost on 18.09.2016.
 */
public class TestUserForm {
    public static void main(String[] args) {

        User user = new User("Вася Володимирович", "mago@mail.ru", "+38099549544", "fdsfsd", Constants.statusClientRole.CLIENT);
        UserFormMain form = new UserFormMain(user);
    }
}
