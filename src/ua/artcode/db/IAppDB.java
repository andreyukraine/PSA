package ua.artcode.db;

import ua.artcode.model.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
    Map<String, Service> getListServiceApp(); //часто
    Map<String, ModeratorPSA> getModeratorPSA();
    Map<String, Company> getListCompanies(); //часто
    Company getCompanyModerator(int moderatroId);
    Map<Long, User> getListAutorizationClient();


    Map<String, Client> getListClients();

    long addAutorizationClient(LocalDateTime data, User user);




    Map<String, Moderator> getListModerator();

    Map<String, Worker> getListWorkers();  //часто
    Client addModeratorCompany(Client client);
    Service addService(Service service);
    Client removeClient(long clientId);
    Client addClient(Client client);
    Location addLocation(Location location);
    Company addCompany(Company company);
    String searchService(String serviceName); //часто
    Worker createWorker(Moderator moderator, Worker worker);
    Worker addWorker(Worker worker);
    Moderator addModerator(Moderator moderator);
    Service inputService(int serviceId);
    Map<String, Worker> showAllFreeWorker();
    Company getCompanyOfService(String serviceName);
    //List<Service> addServiceCompany(Service service, String nameCompany);

}
