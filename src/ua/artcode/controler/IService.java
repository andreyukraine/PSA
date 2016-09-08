package ua.artcode.controler;

import ua.artcode.model.Company;
import ua.artcode.model.Service;
import ua.artcode.model.Worker;

import java.util.List;

/**
 * Created by ladapodborska on 9/5/16.
 */
public interface IService {


    ///addService to app
    Service addService(String nameService, String descriptionService);

    //remove service from app
    Service rmServiceFromApp(long serviceId);

    //edit information about service
    Service editService(long serviceId, String newNameService, String newDescriptionService);

    //get list of all services in app
    List<Service> getAllServicesApp();

    //setService
    Service setService(long serviceId);








    //add service to company
    Service addServiceToCompany(Company company, Service service);

    //remove service from company
    Service rmServiceFromCompany(long companyId, long serviceId);

    //asign service to worker
    Service asignServiceWorker(long serviceId, Worker worker);


    //get list of all services in company
    List<Service> getAllServicesCompany(long companyId);
}
