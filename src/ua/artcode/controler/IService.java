package ua.artcode.controler;

import ua.artcode.model.Service;
import ua.artcode.model.Worker;

import java.util.List;

/**
 * Created by ladapodborska on 9/5/16.
 */
public interface IService {

    //addService to app
    Service addService(Service service);

    //add service to company
    Service addServiceToCompany(long companyId, long serviceId);

    //edit information about service
    Service editService(long serviceId, String newServiceName, String newServiceDescription);

    //remove service from app
    Service rmServiceFromApp(long serviceId);

    //remove service from company
    Service rmServiceFromCompany(long companyId, long serviceId);

    //asign service to worker
    Service asignServiceWorker(long serviceId, Worker worker);

    //get list of all services in app
    List<Service> getAllServicesApp();

    //get list of all services in company
    List<Service> getAllServicesCompany(long companyId);
}
