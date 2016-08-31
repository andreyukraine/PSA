package ua.artcode.controler;

import ua.artcode.model.*;

/**
 * Created by IT on 22.08.2016.
 */
public class IClientCotrollerImp implements IClientController {

    @Override
    public User register(String email, String fullname, String phone, String pass, String role) {
        return null;
    }

    @Override
    public Service[] searchService() {
        return new Service[0];
    }

    @Override
    public Order createOrder(Company company, Service service) {
        return null;
    }

    @Override
    public Comment addCommentService(Service service) {
        return null;
    }

    @Override
    public Comment addCommentCompany(Company company) {
        return null;
    }

    @Override
    public Comment addCommentWorker(Worker worker) {
        return null;
    }

    @Override
    public Comment addCommentPSA() {
        return null;
    }

    @Override
    public Order editOrder() {
        return null;
    }

    @Override
    public Order closeOrder() {
        return null;
    }

    @Override
    public Order[] listOrders(User user, Status status) {
        return new Order[0];
    }
}
