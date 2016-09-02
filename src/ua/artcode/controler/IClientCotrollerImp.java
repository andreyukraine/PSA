package ua.artcode.controler;

import ua.artcode.model.*;
import ua.artcode.run.RunProgramms;

import java.util.List;

/**
 * Created by IT on 22.08.2016.
 */
public class IClientCotrollerImp implements IClientController {

    @Override
    public Client addClient(String email, String fullname, String phone, String pass, String role) {
        return null;
    }

    @Override
    public Company addCompany(String nameCompany, String descriptionCompany, Client moderator, Location location ) {
        Company company = new Company(nameCompany,descriptionCompany,moderator,location);
        return RunProgramms.appDB.addCompany(company);
    }

    @Override
    public Service searchService(String serviceName) {
        return RunProgramms.appDB.searchService(serviceName);
    }

    @Override
    public Order createOrder(Company company, Service service) {
        return null;
    }

    @Override
    public Order editOrder() {
        return null;
    }

    @Override
    public Order statusOrder() {
        return null;
    }

    @Override
    public List<Order> listOrders(Client client) {
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




}
