package ua.artcode.model;

import ua.artcode.utils.Constants;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT on 21.08.2016.
 */
public class Worker extends User {

    private Company company;
    private Constants.statusCompany status;
    private Rate rateWorker;

    private List<Service> service;
    private List<Order> orders;


    // constructors --------------------------------------------------------------------------------


    public Worker() {
    }

    public Worker(String fullname, String email, String phone,String pass, Constants.statusClientRole role) {

        super(fullname, email, phone, pass, role);

    }


    // geters & seters -----------------------------------------------------------------------------

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Constants.statusCompany getStatus() {
        return status;
    }

    public void setStatus(Constants.statusCompany status) {
        this.status = status;
    }

    public Rate getRateWorker() {
        return rateWorker;
    }

    public void setRateWorker(Rate rateWorker) {
        this.rateWorker = rateWorker;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
