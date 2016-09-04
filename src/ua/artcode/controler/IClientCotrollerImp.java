package ua.artcode.controler;

import ua.artcode.db.IAppDB;
import ua.artcode.model.*;
import ua.artcode.run.RunProgram;

import java.util.List;

/**
 * Created by IT on 22.08.2016.
 */
public class IClientCotrollerImp implements IClientController {


    private IAppDB appDB;

    public IClientCotrollerImp(IAppDB appDB) {
        this.appDB = appDB;
    }

    @Override
    public Client addClient(String email, String fullname, String phone, String pass, String role) {
        return null;
    }

    @Override
    public Company addCompany(String nameCompany, String descriptionCompany, Client client, Location location, List<Service> service) {
        Company company = new Company(nameCompany,descriptionCompany,client,location, service);
        return appDB.addCompany(company);
    }

    @Override
    public String searchService(String serviceName) {
        return appDB.searchService(serviceName);
    }

    @Override
    public Service inputService(int serviceId) {
       return appDB.inputService(serviceId);
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
