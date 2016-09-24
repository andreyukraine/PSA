package ua.artcode.controler;

import ua.artcode.db.AppDBImpl;
import ua.artcode.model.Company;
import ua.artcode.model.Service;
import ua.artcode.model.Worker;
import ua.artcode.utils.DBFileHandler;

import java.util.List;
import java.util.Map;

/**
 * Created by ladapodborska on 9/5/16.
 */
public class ServiceImp implements IService{


    private AppDBImpl appDB;
    private DBFileHandler dbFileHandler;

    public ServiceImp() {
    }

    public ServiceImp(AppDBImpl appDB, DBFileHandler dbFileHandler) {
        this.appDB = appDB;
        this.dbFileHandler = dbFileHandler;
    }

    @Override
    public Service addService(String nameService, String descriptionService) {
        Service service = new Service(nameService, descriptionService);
        return appDB.addService(service);
    }

    @Override
    public Service rmServiceFromApp(long serviceId) {
        return appDB.removeService(serviceId);
    }

    @Override
    public Service editService(long serviceId, String newNameService, String newDescriptionService) {
        return appDB.editService(serviceId, newNameService, newDescriptionService);
    }

    @Override
    public Map<String, Service> getAllServicesApp() {
        return appDB.getListServiceApp();
    }

    @Override
    public Service setService(long serviceId) {
        return appDB.setService(serviceId);
    }

    @Override
    public Service addServiceToCompany(Company company, Service service) {
        return appDB.addServiceToCompany(company,service);
    }

















    @Override
    public Service rmServiceFromCompany(long companyId, long serviceId) {
        return null;
    }

    @Override
    public Service asignServiceWorker(long serviceId, Worker worker) {
        return null;
    }



    @Override
    public Map<String, Service> getAllServicesCompany(long companyId) {
        return null;
    }
}
