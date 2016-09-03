package ua.artcode.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT on 21.08.2016.
 */
public class Worker extends User {

    //w+1
    //w+2
    private Company company;
    private String descriptionWorker;
    private Status status;
    private Rate rateWorker;

    private List<Service> service;
    private List<Order> orders;


    // constructors --------------------------------------------------------------------------------


    public Worker() {
    }

    public Worker(String fullname, String email, String phone, String pass, String descriptionWorker) {

        super(fullname, email, phone, pass, descriptionWorker);
        this.descriptionWorker = descriptionWorker;
    }


    // geters & seters -----------------------------------------------------------------------------

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescriptionWorker() {
        return descriptionWorker;
    }

    public void setDescriptionWorker(String descriptionWorker) {
        this.descriptionWorker = descriptionWorker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
