package ua.artcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT on 21.08.2016.
 */
public class Moderator extends User{

    private Company company;
    private List<Worker> workers = new ArrayList<>();
    private List<Service> services;
    private List<Order> orders;
    private List<Comment> commentsCompany;
    private List<Comment> commentsService;
    private List<Comment> commentsWorker;


    // constructors --------------------------------------------------------------------------------

    public Moderator(String fullname ,String email, String phone, String pass, String role, List<Worker> worker) {
        super(fullname, email, phone, pass, role);
        this.workers = worker;
    }

    // geters & seters -----------------------------------------------------------------------------


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Comment> getCommentsCompany() {
        return commentsCompany;
    }

    public void setCommentsCompany(List<Comment> commentsCompany) {
        this.commentsCompany = commentsCompany;
    }

    public List<Comment> getCommentsService() {
        return commentsService;
    }

    public void setCommentsService(List<Comment> commentsService) {
        this.commentsService = commentsService;
    }

    public List<Comment> getCommentsWorker() {
        return commentsWorker;
    }

    public void setCommentsWorker(List<Comment> commentsWorker) {
        this.commentsWorker = commentsWorker;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
