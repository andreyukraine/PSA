package ua.artcode.db;

import ua.artcode.model.*;
import ua.artcode.utils.Constants;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


public class AppDBImpl implements IAppDB, Serializable{


    private static long key;

    private Map<String, Company> companyMap = new TreeMap<>();
    private Map<String, Service> serviceMap = new TreeMap<>();
    private Map<String, Worker> workerList = new TreeMap<>();


    private Map<String, Client> clientsMap = new TreeMap<>();
    private Map<Long, User> autorizationClient = new TreeMap<>();
    private Map<String, Moderator> moderatorList = new TreeMap<>();
    private Map<String, ModeratorPSA> moderatorPSA = new TreeMap<>();
    private Map<String, Location> locations = new TreeMap<>();


    private List<Comment> commentsPSA = new ArrayList<>();
    private List<Comment> commentsCompany = new ArrayList<>();
    private List<Comment> commentsService = new ArrayList<>();
    private List<Comment> commentsWorker = new ArrayList<>();


    @Override
    public Service addService(Service service) {
        serviceMap.put(service.getNameService(), service);
        return service;
    }

    @Override
    public Company addCompany(Company company) {
        companyMap.put(company.getNameCompany(),company);
        return company;
    }

    @Override
    public String searchService(String serviceName) {
        for (int i = 0; i < serviceMap.size() ; i++) {
            if (serviceMap.get(i).getNameService().equals(serviceName)){
                return String.format(" %d, name %s, desc %s", i , serviceMap.get(i).getNameService(), serviceMap.get(i).getDescriptionService());
            }

        }
        return null;
    }

    @Override
    public Worker createWorker(Moderator moderator, Worker worker) {
        workerList.put(worker.getFullname(),worker);
        Map<String, Worker> workers = new TreeMap<>();
        workers.put(worker.getFullname(), worker);
        moderator.setWorkers(workers);
        worker.setCompany(moderator.getCompany());
        worker.setService(moderator.getServices());
        return worker;
    }

    @Override
    public Moderator addModerator(Moderator moderator) {
        moderatorList.put(moderator.getFullname(), moderator);
        return moderator;
    }

    @Override
    public Company getCompanyModerator(int moderatroId){
        for (int i = 0; i < getListModerator().size(); i++) {
            if (getListModerator().get(i).getId() == moderatroId){
                return getListModerator().get(i).getCompany();
            }
        }
        return null;
    }

    @Override
    public Map<Long, User> getListAutorizationClient() {
        return autorizationClient;
    }

    @Override
    public Map<String, Client> getListClients() {
        return clientsMap;
    }


    @Override
    public long addAutorizationClient(LocalDateTime date, User user) {
        Date sDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        autorizationClient.put(sDate.getTime(),user);
        return sDate.getTime();
    }

    @Override
    public Service inputService(int serviceId) {
        for (int i = 0; i < serviceMap.size() ; i++) {
            if (serviceMap.get(i).getId() == serviceId){
                return serviceMap.get(i);
            }
        }
        return null;
    }

    @Override
    public Map<String, Worker> showAllFreeWorker() {
        Map<String, Worker> workersFree = new TreeMap<>();
        for (Map.Entry<String, Worker> entry : getWorkerList().entrySet()){
            if (entry.getValue().getStatus().equals(Constants.statusWorker.FREE)){
                workersFree.put(entry.getKey(),entry.getValue());
                return workersFree;
            }
        }
        return null;
    }

    @Override
    public Company getCompanyOfService(String serviceName) {
        for (Map.Entry<String, Company> entry : companyMap.entrySet()){
           if (entry.getValue().getServices().equals(serviceName)){
               return entry.getValue();
           }
        }
        return null;
    }

//    @Override
//    public List<Service> addServiceCompany(Service service, String nameCompany) {
//        for (int i = 0; i < companyMap.size(); i++) {
//            if (companyMap.get(i).getNameCompany().equals(nameCompany)){
//                List<Service> services = new ArrayList<>();
//                services.add(service);
//                companyMap.get(i).setServices(services);
//                return services;
//            }
//        }
//        return null;
//    }

    @Override
    public ModeratorPSA addModeratorPSA(ModeratorPSA moderatorPSA) {
        this.moderatorPSA.put(moderatorPSA.getFullname(), moderatorPSA);
        return moderatorPSA;
    }

    @Override
    public Service editService(long serviceId, String newNameService, String newDescriptionService) {

        for (int i = 0; i < serviceMap.size(); i++) {
            if (serviceMap.get(i).getId() == serviceId) {
                serviceMap.get(i).setNameService(newNameService);
                serviceMap.get(i).setDescriptionService(newDescriptionService);
                return serviceMap.get(i);
            }
        }
        return null;
    }

    @Override
    public Service setService(long serviceId) {
        for (int i = 0; i < serviceMap.size() ; i++) {
            if (serviceMap.get(i).getId() == serviceId){
                return serviceMap.get(i);
            }
        }
        return null;
    }

    public Service addServiceToCompany(Company company, Service service){
        for (int i = 0; i < companyMap.size() ; i++) {
            if (companyMap.get(i).getId() == company.getId()){
                List<Service> services = new ArrayList<>();
                services.add(service);
                companyMap.get(i).setServices(service);
                return service;
            }
        }
        return null;
    }


    @Override
    public Service removeService(long serviceId) {
        for (int i = 0; i < serviceMap.size(); i++) {
            if (serviceMap.get(i).getId() == serviceId) {
                Service service = serviceMap.get(i);
                serviceMap.remove(i);
                return service;
            }
        }
        return null;
    }

    public Client removeClient(long clientId){
        for (int i = 0; i < clientsMap.size() ; i++) {
            if (clientsMap.get(i).getId() == clientId){
                Client client = clientsMap.get(i);
                clientsMap.remove(i);
                return client;
            }
        }
        return null;
    }
    @Override
    public Company removeCompany(long companyId) {
        for (int i = 0; i < companyMap.size() ; i++) {
            if (companyMap.get(i).getId() == companyId){
                Company company = companyMap.get(i);
                companyMap.remove(i);
                return company;
            }
        }
        return null;
    }

    @Override
    public Client addClient(Client client) {

        clientsMap.put(client.getFullname(),client);
        return client;
    }

    @Override
    public Worker addWorker(Worker worker) {
        workerList.put(worker.getFullname(), worker);
        return worker;
    }

    @Override
    public Location addLocation(Location location) {
        locations.put(location.getCity(), location);
        return location;
    }

    public Client addModeratorCompany(Client client) {
        for (int i = 0; i < clientsMap.size(); i++) {
            if (clientsMap.get(i).getId() == client.getId()) {
                Moderator moderator = new Moderator(clientsMap.get(i).getFullname(), clientsMap.get(i).getEmail(),
                        clientsMap.get(i).getPhone(), clientsMap.get(i).getPass(), Constants.statusClientRole.MODERATOR,null);
                moderatorList.put(moderator.getFullname(), moderator);
                clientsMap.remove(i);
                return client;

            }
        }
        return null;
    }

    public Map<String, ModeratorPSA> getModeratorPSA() {
        return moderatorPSA;
    }

    @Override
    public Map<String, Company> getListCompanies() {
        return companyMap;
    }


    @Override
    public Map<String, Worker> getListWorkers() {
        return workerList;
    }

    @Override
    public Map<String, Service> getListServiceApp() {
        return serviceMap;
    }

    @Override
    public Map<String, Moderator> getListModerator() {
        return moderatorList;
    }


    // constructors --------------------------------------------------------------------------------

    public AppDBImpl()  {
    }

    public AppDBImpl(Map<String, Company> companies, Map<String, Client> clients, Map<String, Moderator> moderator,
                     Map<String, Service> services, Map<String, ModeratorPSA> listModeratorPSA) {
        this.companyMap = companies;
        this.clientsMap = clients;
        this.moderatorList = moderator;
        this.serviceMap = services;
        this.moderatorPSA = listModeratorPSA;
    }

    // geters & seters -----------------------------------------------------------------------------


    public Map<String, Company> getCompanyMap() {
        return companyMap;
    }

    public void setCompanyMap(Map<String, Company> companyMap) {
        this.companyMap = companyMap;
    }

    public Map<String, Client> getClientsMap() {
        return clientsMap;
    }

    public void setClientsMap(Map<String, Client> clientsMap) {
        this.clientsMap = clientsMap;
    }

    public Map<String, Moderator> getModeratorList() {
        return moderatorList;
    }

    public void setModeratorList(Map<String, Moderator> moderatorList) {
        this.moderatorList = moderatorList;
    }

    public Map<String, Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(Map<String, Worker> workerList) {
        this.workerList = workerList;
    }

    public Map<String, Location> getLocations() {
        return locations;
    }

    public void setLocations(Map<String, Location> locations) {
        this.locations = locations;
    }

    public Map<String, Service> getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(Map<String, Service> serviceMap) {
        this.serviceMap = serviceMap;
    }

    public void setModeratorPSA(Map<String, ModeratorPSA> moderatorPSA) {
        this.moderatorPSA = moderatorPSA;
    }

//    public List<Comment> getCommentsPSA() {
//        return commentsPSA;
//    }
//
//    public void setCommentsPSA(List<Comment> commentsPSA) {
//        this.commentsPSA = commentsPSA;
//    }
//
//    public List<Comment> getCommentsCompany() {
//        return commentsCompany;
//    }
//
//    public void setCommentsCompany(List<Comment> commentsCompany) {
//        this.commentsCompany = commentsCompany;
//    }
//
//    public List<Comment> getCommentsService() {
//        return commentsService;
//    }
//
//    public void setCommentsService(List<Comment> commentsService) {
//        this.commentsService = commentsService;
//    }
//
//    public List<Comment> getCommentsWorker() {
//        return commentsWorker;
//    }
//
//    public void setCommentsWorker(List<Comment> commentsWorker) {
//        this.commentsWorker = commentsWorker;
//    }
}
