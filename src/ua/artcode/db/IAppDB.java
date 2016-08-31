package ua.artcode.db;

import ua.artcode.model.*;

import java.util.List;


/**
 * crud operation
 */
public interface IAppDB {

    //
    ModeratorPSA addModeratorPSA(ModeratorPSA moderatorPSA);
    List<ModeratorPSA> getListModeratorPSA();
    List<Company> getListCompanies();
    List<Service> getListService();
    List<Moderator> getListModerator();
    List<Client> getListClients();
    Service addService(Service service);
    String editService(long serviceId, String newNameService, String newDescriptionService);
    String removeService(long serviceId);
    Client addClient(Client client);
    Company addCompany(Company company);
}
