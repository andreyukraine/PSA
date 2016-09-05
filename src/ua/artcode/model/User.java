package ua.artcode.model;

import ua.artcode.utils.Constants;

import java.io.Serializable;

/**
 * Created by serhii on 21.08.16.
 */
public class User implements Serializable {

    //u+1
    //u+2
    private long id;
    private String email;
    private String fullname;
    private String phone;
    private String pass;
    private Constants.statusClientRole role;

    // constructors --------------------------------------------------------------------------------

    public User() {
    }

    public User(String fullname ,String email, String phone, String pass, Constants.statusClientRole role) {
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.role = role;
    }

    // geters & seters -----------------------------------------------------------------------------


    public Constants.statusClientRole getRole() {
        return role;
    }

    public void setRole(Constants.statusClientRole role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
