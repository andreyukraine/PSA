package ua.artcode.controler;

import ua.artcode.db.AppDBImpl;
import ua.artcode.model.*;
import ua.artcode.utils.Constants;
import ua.artcode.utils.DBFileHandler;

import java.util.List;
import java.util.Map;

/**
 * Created by IT on 22.08.2016.
 */
public class IClientCotrollerImp implements IClientController {


    private AppDBImpl appDB;
    private DBFileHandler dbFileHandler;

    public IClientCotrollerImp() {
    }

    public IClientCotrollerImp(AppDBImpl appDB, DBFileHandler dbFileHandler) {
        this.appDB = appDB;
        this.dbFileHandler = dbFileHandler;
    }

    @Override
    public Client removeClient(long clientId) {
        return appDB.removeClient(clientId);
    }

    @Override
    public Map<String, Client> listAllClient() {
        return appDB.getListClients();
    }

    @Override
    public Map<String, Service> listAllService() {
        return appDB.getListServiceApp();
    }

    @Override
    public Map<String, Company> listAllCompany() {
        return appDB.getListCompanies();
    }

    @Override
    public Company getCompanyOfService(String nameService) {
        return appDB.getCompanyOfService(nameService);
    }

    @Override
    public Map<String, Worker> showAllFreeWorker() {
        return appDB.showAllFreeWorker();
    }

    @Override
    public Client addClient(String fullname, String email, String phone, String pass, Constants.statusClientRole role) {
        Client client = new Client(fullname, email, phone, pass, role);
        return appDB.addClient(client);
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




}
