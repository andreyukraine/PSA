package ua.artcode.model;


import ua.artcode.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT on 21.08.2016.
 */
public class ModeratorPSA extends User{



    private List<Company> companies;
    private List<Worker> workers;
    private List<Service> services;
    private List<Comment> commentsPSA;

    // constructors --------------------------------------------------------------------------------

    public ModeratorPSA(String fullname, String email, String phone, String pass, Constants.statusClientRole role) {
        super(fullname, email, phone, pass, role);
    }

    public ModeratorPSA() {
    }

    // geters & seters -----------------------------------------------------------------------------


    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Comment> getCommentsPSA() {
        return commentsPSA;
    }

    public void setCommentsPSA(List<Comment> commentsPSA) {
        this.commentsPSA = commentsPSA;
    }
}
