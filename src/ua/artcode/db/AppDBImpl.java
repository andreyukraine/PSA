package ua.artcode.db;

import ua.artcode.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 21.08.16.
 */
public class AppDBImpl implements IAppDB {

    private List<Company> companies = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private List<Moderator> moderator = new ArrayList<>();
    private List<Service> services = new ArrayList<>();
    private List<ModeratorPSA> listModeratorPSA = new ArrayList<>();




    @Override
    public Service addService(Service service) {
                services.add(service);
                service.setId(services.indexOf(service));
                return service;
    }

    @Override
    public ModeratorPSA addModeratorPSA(ModeratorPSA moderatorPSA) {
            listModeratorPSA.add(moderatorPSA);
            return moderatorPSA;
    }

    @Override
    public String editService(long serviceId, String newNameService, String newDescriptionService) {
        String oldService = "";
        String newService = "";
        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getId() == serviceId){
                oldService = services.get(i).toString();
                services.get(i).setNameService(newNameService);
                services.get(i).setDescriptionService(newDescriptionService);
                newService = services.get(i).toString();
                return String.format("Old service %s, New service %s", oldService, newService);
            }
        }
        return null;
    }

    @Override
    public String removeService(long serviceId) {
        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getId() == serviceId){
                Service service = services.get(i);
                services.remove(i);
                return String.format("Dell service %s", service.toString() );
            }
        }
        return null;
    }

    @Override
    public Client addClient(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public List<ModeratorPSA> getListModeratorPSA() {
        return listModeratorPSA;
    }

    public List<Moderator> getListModerator(){
        return moderator;
    }

    public List<Client> getListClients(){
        return clients;
    }
    @Override
    public List<Service> getListService(){
        return services;
    }
    public List<Company> getListCompanies() {
        return companies;
    }


    public Company addCompany(Company company){
        companies.add(company);
        return company;
    }









//    public Service updateService(long serviceId, Service service){
//
//            for (int i = 0; i < services.size(); i++) {
//                if (services.get(i).getId() == serviceId){
//                    services.set(i, service);
//                    return service;
//                }
//            }
//        try {
//            throw new ServiceNotUpdateException("Servise doesn't exist");
//
//        } catch (ServiceNotUpdateException e) {
//            e.printStackTrace();
//        }
//        return null; //надо как-то правильно добавить exception, чтоб убрать return null;
//    }

    // constructors --------------------------------------------------------------------------------

    public AppDBImpl() {
    }

    public AppDBImpl(ArrayList<Company> companies, ArrayList<Client> clients, ArrayList<Moderator> moderator,
                     ArrayList<Service> services, ArrayList<ModeratorPSA> listModeratorPSA) {
        this.companies = companies;
        this.clients = clients;
        this.moderator = moderator;
        this.services = services;
        this.listModeratorPSA = listModeratorPSA;
    }

    // geters & seters -----------------------------------------------------------------------------


    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Moderator> getModerator() {
        return moderator;
    }

    public void setModerator(List<Moderator> moderator) {
        this.moderator = moderator;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public void setListModeratorPSA(ArrayList<ModeratorPSA> listModeratorPSA) {
        this.listModeratorPSA = listModeratorPSA;
    }
}
