package ua.artcode.db;

import ua.artcode.model.*;

import java.util.List;


/**
 * crud operation
 */
public interface IAppDB {

    //
    ModeratorPSA addModeratorPSA(ModeratorPSA moderatorPSA);
    List<ModeratorPSA> getModeratorPSA();
    List<Company> getListCompanies();
    List<Service> getListService();
    List<Moderator> getListModerator();
    List<Client> getListClients();
    List<Worker> getListWorkers();
    Client addModeratorCompany(Client client, Company company);
    Service addService(Service service);
    String editService(long serviceId, String newNameService, String newDescriptionService);
    Service removeService(long serviceId);
    Company removeCompany(long companyId);
    Client removeClient(long clientId);
    Client addClient(Client client);
    Location addLocation(Location location);
    Company addCompany(Company company);
    String searchService(String serviceName);
    Worker createWorker(Moderator moderator, Worker worker);
    Worker addWorker(Worker worker);
    Moderator addModerator(Moderator moderator);
    Service inputService(int serviceId);
    List<Service> addServiceCompany(Service service, String nameCompany);

}
