package ua.artcode.controler;

import ua.artcode.db.AppDBImpl;
import ua.artcode.exceptions.AppException;
import ua.artcode.exceptions.ModeratorExeption;
import ua.artcode.model.*;
import ua.artcode.utils.Constants;
import ua.artcode.utils.DBFileHandler;

import java.util.List;


/**
 * Created by IT on 22.08.2016.
 */
public class IModeratorPSAControllerImp implements IModeratorPSAController {

    private AppDBImpl appDB;
    private DBFileHandler dbFileHandler;

    public IModeratorPSAControllerImp() {
    }

    public IModeratorPSAControllerImp(AppDBImpl appDB, DBFileHandler dbFileHandler) {
        this.appDB = appDB;
        this.dbFileHandler = dbFileHandler;
    }

    @Override
    public ModeratorPSA addModeratorPSA(String fullname, String email, String phone, String pass, Constants.statusClientRole role) {
        ModeratorPSA moderatorPSA = new ModeratorPSA(fullname, email, phone, pass, role);
        return appDB.addModeratorPSA(moderatorPSA);
    }

    @Override
    public Service addService(String nameService, String descriptionService) {
        Service service = new Service(nameService, descriptionService);
        return appDB.addService(service);
    }

    @Override
    public Service removeService(long serviceId) {
        return appDB.removeService(serviceId);
    }

    @Override
    public String editService(long serviceId, String newNameService, String newDescriptionService) {
        return appDB.editService(serviceId, newNameService, newDescriptionService);
    }

    @Override
    public Company changeStatusCompany(long companyId, Constants.statusCompany status) {
        for (int i = 0; i < appDB.getListCompanies().size(); i++) {
            if (appDB.getListCompanies().get(i).getId() == companyId) {
               // appDB.getListCompanies().get(i).setChangeStatusCompany(Constants.statusCompany.);
                return appDB.getListCompanies().get(i);
            }
        }
        return null;
    }

    @Override
    public Company addCompany(String nameCompany, String descriptionCompany, Client client, Location location, List<Service> service) {
        Company company = new Company(nameCompany, descriptionCompany, client, location, service);
        return appDB.addCompany(company);
    }

    @Override
    public Company removeCompany(long companyId) {
        return  appDB.removeCompany(companyId);
    }

    @Override
    public Client removeClient(long clientId) {
        return appDB.removeClient(clientId);
    }

    @Override
    public List<Company> listAllCompany() {
        return appDB.getListCompanies();
    }

    @Override
    public List<Client> listAllClient() {
        return appDB.getListClients();
    }

    @Override
    public List<Service> listAllService() {
        return appDB.getListService();
    }

    @Override
    public List<Moderator> listAllModerator() throws ModeratorExeption {
        return appDB.getListModerator();
    }

    @Override
    public Client addClient(String fullname, String email, String phone, String pass, Constants.statusClientRole role) {
        Client client = new Client(fullname, email, phone, pass, role);
        return appDB.addClient(client);
    }


    @Override
    public Location addLocation(String country, String city) {
        Location location = new Location(country, city);
        return appDB.addLocation(location);
    }

    @Override
    public void saveAllToDb() throws AppException {
        dbFileHandler.save(appDB);
    }

    @Override
    public void loadAllFromDb() throws AppException {
        appDB = dbFileHandler.load();
    }

    @Override
    public String dbToJson() throws AppException {
        return null;
    }
}
