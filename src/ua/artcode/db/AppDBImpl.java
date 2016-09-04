package ua.artcode.db;

import ua.artcode.model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 21.08.16.
 */
public class AppDBImpl implements IAppDB, Serializable{

    private List<Company> companyList = new ArrayList<>();
    private List<Client> clientList = new ArrayList<>();
    private List<Moderator> moderatorList = new ArrayList<>();
    private List<Worker> workerList = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    private List<Service> serviceList = new ArrayList<>();
    private List<ModeratorPSA> moderatorPSA = new ArrayList<>();
    private List<Comment> commentsPSA = new ArrayList<>();
    private List<Comment> commentsCompany = new ArrayList<>();
    private List<Comment> commentsService = new ArrayList<>();
    private List<Comment> commentsWorker = new ArrayList<>();


    @Override
    public Service addService(Service service) {
        serviceList.add(service);
        service.setId(serviceList.indexOf(service));
        return service;
    }

    @Override
    public Company addCompany(Company company) {
        companyList.add(company);
        company.setId(companyList.indexOf(company));
        return company;
    }

    @Override
    public String searchService(String serviceName) {
        for (int i = 0; i < serviceList.size() ; i++) {
            if (serviceList.get(i).getNameService().equals(serviceName)){
                return String.format(" %d, name %s, desc %s", i ,serviceList.get(i).getNameService(),serviceList.get(i).getDescriptionService());
            }

        }
        return null;
    }

    @Override
    public Worker createWorker(Moderator moderator, Worker worker) {
        workerList.add(worker);
        List<Worker> workers = new ArrayList<>();
        workers.add(worker);
        moderator.setWorkers(workers);
        worker.setCompany(moderator.getCompany());
        worker.setService(moderator.getServices());
        return worker;
    }

    @Override
    public Moderator addModerator(Moderator moderator) {
        moderatorList.add(moderator);
        moderator.setId(moderatorList.indexOf(moderator));
        return moderator;
    }

    @Override
    public Service inputService(int serviceId) {
        for (int i = 0; i < serviceList.size() ; i++) {
            if (serviceList.get(i).getId() == serviceId){
                return serviceList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Service> addServiceCompany(Service service, String nameCompany) {
        for (int i = 0; i < companyList.size(); i++) {
            if (companyList.get(i).getNameCompany().equals(nameCompany)){
                List<Service> services = new ArrayList<>();
                services.add(service);
                companyList.get(i).setServices(services);
                return services;
            }
        }
        return null;
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
        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).getId() == serviceId) {
                oldService = serviceList.get(i).toString();
                serviceList.get(i).setNameService(newNameService);
                serviceList.get(i).setDescriptionService(newDescriptionService);
                newService = serviceList.get(i).toString();
                return String.format("Old service %s, New service %s", oldService, newService);
            }
        }
        return null;
    }

    @Override
    public Service removeService(long serviceId) {
        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).getId() == serviceId) {
                Service service = serviceList.get(i);
                serviceList.remove(i);
                return service;
            }
        }
        return null;
    }

    public Client removeClient(long clientId){
        for (int i = 0; i < clientList.size() ; i++) {
            if (clientList.get(i).getId() == clientId){
                Client client = clientList.get(i);
                clientList.remove(i);
                return client;
            }
        }
        return null;
    }
    @Override
    public Company removeCompany(long companyId) {
        for (int i = 0; i < companyList.size() ; i++) {
            if (companyList.get(i).getId() == companyId){
                Company company = companyList.get((int) companyId);
                companyList.remove(i);
                return company;
            }
        }
        return null;
    }

    @Override
    public Client addClient(Client client) {
        clientList.add(client);
        client.setId(clientList.indexOf(client));
        return client;
    }

    @Override
    public Worker addWorker(Worker worker) {
        workerList.add(worker);
        worker.setId(workerList.indexOf(worker));
        return worker;
    }

    @Override
    public Location addLocation(Location location) {
        locations.add(location);
        location.setId(locations.indexOf(location));
        return location;
    }

    public Client addModeratorCompany(Client client, Company company) {
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getId() == client.getId()) {
                Moderator moderator = new Moderator(clientList.get(i).getFullname(), clientList.get(i).getEmail(),
                        clientList.get(i).getPhone(), clientList.get(i).getPass(),new Status().statusClientRole(2),null);
                moderator.setCompany(company);
                moderator.setServices(company.getServices());
                moderatorList.add(moderator);

                company.setModerator(client);
                company.setServices(moderator.getServices());

                clientList.remove(i);
                return client;

            }
        }
        return null;
    }

    public List<ModeratorPSA> getModeratorPSA() {
        return moderatorPSA;
    }


    public List<Client> getListClients() {
        return clientList;
    }

    @Override
    public List<Worker> getListWorkers() {
        return workerList;
    }

    @Override
    public List<Service> getListService() {
        return serviceList;
    }

    @Override
    public List<Moderator> getListModerator() {
        return moderatorList;
    }

    public List<Company> getListCompanies() {
        return companyList;
    }

    // constructors --------------------------------------------------------------------------------

    public AppDBImpl() {
    }

    public AppDBImpl(ArrayList<Company> companies, ArrayList<Client> clients, ArrayList<Moderator> moderator,
                     ArrayList<Service> services, ArrayList<ModeratorPSA> listModeratorPSA) {
        this.companyList = companies;
        this.clientList = clients;
        this.moderatorList = moderator;
        this.serviceList = services;
        this.moderatorPSA = listModeratorPSA;
    }

    // geters & seters -----------------------------------------------------------------------------


    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Moderator> getModeratorList() {
        return moderatorList;
    }

    public void setModeratorList(List<Moderator> moderatorList) {
        this.moderatorList = moderatorList;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
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
