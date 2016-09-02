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
    private List<Moderator> moderators = new ArrayList<>();
    private List<Worker> workers = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    private List<Service> services = new ArrayList<>();
    private List<ModeratorPSA> moderatorPSA = new ArrayList<>();
    private List<Comment> commentsPSA = new ArrayList<>();
    private List<Comment> commentsCompany = new ArrayList<>();
    private List<Comment> commentsService = new ArrayList<>();
    private List<Comment> commentsWorker = new ArrayList<>();


    @Override
    public Service addService(Service service) {
        services.add(service);
        service.setId(services.indexOf(service));
        return service;
    }

    @Override
    public Company addCompany(Company company) {
        companies.add(company);
        company.setId(companies.indexOf(company));
        return company;
    }

    @Override
    public Service searchService(String serviceName) {
        for (int i = 0; i < services.size() ; i++) {
            if (services.get(i).getNameService().equals(serviceName)){
                return services.get(i);
            }

        }
        return null;
    }

    @Override
    public Worker createWorker(Worker worker) {
        workers.add(worker);
        worker.setId(workers.indexOf(worker));
        return worker;
    }

    @Override
    public Moderator addModerator(Moderator moderator) {
        moderators.add(moderator);
        moderator.setId(moderators.indexOf(moderator));
        return moderator;
    }

    @Override
    public Worker asignWorkerToModerator(Moderator moderator, Worker worker) {
       return  null;
    }

    @Override
    public ModeratorPSA addModeratorPSA(ModeratorPSA moderatorPSA) {
        this.moderatorPSA.add(moderatorPSA);
        return moderatorPSA;
    }

    @Override
    public String editService(long serviceId, String newNameService, String newDescriptionService) {
        String oldService = "";
        String newService = "";
        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getId() == serviceId) {
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
    public Service removeService(long serviceId) {
        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getId() == serviceId) {
                Service service = services.get(i);
                services.remove(i);
                return service;
            }
        }
        return null;
    }

    public Client removeClient(long clientId){
        for (int i = 0; i < clients.size() ; i++) {
            if (clients.get(i).getId() == clientId){
                Client client = clients.get(i);
                clients.remove(i);
                return client;
            }
        }
        return null;
    }
    @Override
    public Company removeCompany(long companyId) {
        for (int i = 0; i < companies.size() ; i++) {
            if (companies.get(i).getId() == companyId){
                Company company = companies.get((int) companyId);
                companies.remove(i);
                return company;
            }
        }
        return null;
    }

    @Override
    public Client addClient(Client client) {
        clients.add(client);
        client.setId(clients.indexOf(client));
        return client;
    }

    @Override
    public Worker addWorker(Worker worker) {
        workers.add(worker);
        worker.setId(workers.indexOf(worker));
        return worker;
    }

    @Override
    public Location addLocation(Location location) {
        locations.add(location);
        location.setId(locations.indexOf(location));
        return location;
    }

    public Client addModeratorCompany(Client client) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == client.getId()) {
                Moderator moderator = new Moderator(clients.get(i).getFullname(),clients.get(i).getEmail(),
                        clients.get(i).getPhone(),clients.get(i).getPass(),new Status().statusClientRole(2));
                moderators.add(moderator);
                clients.remove(i);
                return client;

            }
        }
        return null;
    }

    public List<ModeratorPSA> getModeratorPSA() {
        return moderatorPSA;
    }


    public List<Client> getListClients() {
        return clients;
    }

    @Override
    public List<Worker> getListWorkers() {
        return workers;
    }

    @Override
    public List<Service> getListService() {
        return services;
    }

    @Override
    public List<Moderator> getListModerator() {
        return moderators;
    }

    public List<Company> getListCompanies() {
        return companies;
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
        this.moderators = moderator;
        this.services = services;
        this.moderatorPSA = listModeratorPSA;
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

    public List<Moderator> getModerators() {
        return moderators;
    }

    public void setModerators(List<Moderator> moderators) {
        this.moderators = moderators;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void setModeratorPSA(List<ModeratorPSA> moderatorPSA) {
        this.moderatorPSA = moderatorPSA;
    }

    public List<Comment> getCommentsPSA() {
        return commentsPSA;
    }

    public void setCommentsPSA(List<Comment> commentsPSA) {
        this.commentsPSA = commentsPSA;
    }

    public List<Comment> getCommentsCompany() {
        return commentsCompany;
    }

    public void setCommentsCompany(List<Comment> commentsCompany) {
        this.commentsCompany = commentsCompany;
    }

    public List<Comment> getCommentsService() {
        return commentsService;
    }

    public void setCommentsService(List<Comment> commentsService) {
        this.commentsService = commentsService;
    }

    public List<Comment> getCommentsWorker() {
        return commentsWorker;
    }

    public void setCommentsWorker(List<Comment> commentsWorker) {
        this.commentsWorker = commentsWorker;
    }
}
