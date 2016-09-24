package ua.artcode.model;

import ua.artcode.utils.Constants;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by IT on 21.08.2016.
 */
public class Moderator extends User{

    private Company company;
    private Map<String, Worker> workers = new TreeMap<>();
    private List<Service> services;
    private List<Order> orders;
    private List<Comment> commentsCompany;
    private List<Comment> commentsService;
    private List<Comment> commentsWorker;


    // constructors --------------------------------------------------------------------------------

    public Moderator(String fullname , String email, String phone, String pass, Constants.StatusClientRole role, Map<String, Worker> worker) {
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

    public Map<String, Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Map<String, Worker> workers) {
        this.workers = workers;
    }
}
