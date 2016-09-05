package ua.artcode.controler;

import ua.artcode.model.Service;
import ua.artcode.model.Worker;

import java.util.List;

/**
 * Created by ladapodborska on 9/5/16.
 */
public class ServiceImp implements IService{
    @Override
    public Service addService(Service service) {
        return null;
    }

    @Override
    public Service addServiceToCompany(long companyId, long serviceId) {
        return null;
    }

    @Override
    public Service editService(long serviceId, String newServiceName, String newServiceDescription) {
        return null;
    }

    @Override
    public Service rmServiceFromApp(long serviceId) {
        return null;
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
    public List<Service> getAllServicesApp() {
        return null;
    }

    @Override
    public List<Service> getAllServicesCompany(long companyId) {
        return null;
    }
}
