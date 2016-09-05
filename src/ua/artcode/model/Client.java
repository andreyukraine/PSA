package ua.artcode.model;

import ua.artcode.utils.Constants;

/**
 * Created by IT on 22.08.2016.
 */
public class Client extends User {



    // constructors --------------------------------------------------------------------------------

    public Client(String fullname, String email, String phone, String pass, Constants.statusClientRole role) {
        super(fullname, email, phone, pass, role);
    }

    public Client() {
    }

    // geters & seters -----------------------------------------------------------------------------

}
