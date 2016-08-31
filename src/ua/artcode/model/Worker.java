package ua.artcode.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

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

    private Service[] service;
    private Order[] orders;


    // constructors --------------------------------------------------------------------------------

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

    public Service[] getServices() {
        return service;
    }

    public void setService(Service[] service) {
        this.service = service;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }
}
