package ua.artcode.db;

import ua.artcode.model.*;

import java.io.Serializable;
import java.util.List;


/**
 * crud operation
 */
public interface IAppDB{

    //
    ModeratorPSA addModeratorPSA(ModeratorPSA moderatorPSA);
    Service removeService(long serviceId);
    Service editService(long serviceId, String newNameService, String newDescriptionService);
    Service setService(long serviceId);
    Service addServiceToCompany(Company company, Service service);
    Company removeCompany(long companyId);
    List<Service> getListServiceApp();
    List<ModeratorPSA> getModeratorPSA();
    List<Company> getListCompanies();
    Company getCompanyModerator(int moderatroId);









    List<Moderator> getListModerator();
    List<Client> getListClients();
    List<Worker> getListWorkers();
    Client addModeratorCompany(Client client, Company company);
    Service addService(Service service);
    Client removeClient(long clientId);
    Client addClient(Client client);
    Location addLocation(Location location);
    Company addCompany(Company company);
    String searchService(String serviceName);
    Worker createWorker(Moderator moderator, Worker worker);
    Worker addWorker(Worker worker);
    Moderator addModerator(Moderator moderator);
    Service inputService(int serviceId);
    //List<Service> addServiceCompany(Service service, String nameCompany);

}
