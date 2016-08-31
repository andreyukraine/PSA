package ua.artcode.model;

/**
 * Created by IT on 21.08.2016.
 */
public class Moderator extends User{

    Company company;

    Worker[] workers;
    Service[] services;
    Order[] orders;
    Comment[] comments;


    // constructors --------------------------------------------------------------------------------

   /* public Moderator(String fullname, String email, String phone, String pass, String role, Company company) {
        super(fullname, email, phone, pass, role);
        this.company = company;
    }*/

    public Moderator(String fullname ,String email, String phone, String pass, String role) {
        super(fullname, email, phone, pass, role);
    }

    // geters & seters -----------------------------------------------------------------------------


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
}
