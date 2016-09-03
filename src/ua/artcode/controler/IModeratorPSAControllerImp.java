package ua.artcode.controler;

import ua.artcode.model.*;
import ua.artcode.run.RunProgramms;

import java.util.List;

import static ua.artcode.test.controller.IModeratorPSAControllerTest.companies;
import static ua.artcode.test.controller.IModeratorPSAControllerTest.services;
import static ua.artcode.test.controller.IModeratorPSAControllerTest.users;

/**
 * Created by IT on 22.08.2016.
 */
public class IModeratorPSAControllerImp implements IModeratorPSAController {

    @Override
    public ModeratorPSA addModeratorPSA(String fullname, String email, String phone, String pass, String role) {
        ModeratorPSA moderatorPSA = new ModeratorPSA(fullname, email, phone, pass, role);
        return RunProgramms.appDB.addModeratorPSA(moderatorPSA);
    }

    @Override
    public Service addService(String nameService, String descriptionService) {
        Service service = new Service(nameService, descriptionService);
        return RunProgramms.appDB.addService(service);
    }

    @Override
    public Service removeService(long serviceId) {
        return RunProgramms.appDB.removeService(serviceId);
    }

    @Override
    public String editService(long serviceId, String newNameService, String newDescriptionService) {
        return RunProgramms.appDB.editService(serviceId, newNameService, newDescriptionService);
    }

    @Override
    public Company changeStatusCompany(long companyId, int status) {
        for (int i = 0; i < RunProgramms.appDB.getListCompanies().size(); i++) {
            if (RunProgramms.appDB.getListCompanies().get(i).getId() == companyId) {
                RunProgramms.appDB.getListCompanies().get(i).setChangeStatusCompany(new Status().statusCompany(status));
                return RunProgramms.appDB.getListCompanies().get(i);
            }
        }
        return null;
    }

    @Override
    public Company addCompany(String nameCompany, String descriptionCompany, Client client, Location location, List<Service> service) {
        Company company = new Company(nameCompany, descriptionCompany, client, location, service);
        return RunProgramms.appDB.addCompany(company);
    }

    @Override
    public Company removeCompany(long companyId) {
        return  RunProgramms.appDB.removeCompany(companyId);
    }

    @Override
    public Client removeClient(long clientId) {
        return RunProgramms.appDB.removeClient(clientId);
    }

    @Override
    public List<Company> listAllCompany() {
        return RunProgramms.appDB.getListCompanies();
    }

    @Override
    public List<Client> listAllClient() {
        return RunProgramms.appDB.getListClients();
    }

    @Override
    public List<Service> listAllService() {
        return RunProgramms.appDB.getListService();
    }

    @Override
    public List<Client> listAllModerator() {
        return null;
    }

    @Override
    public Client addClient(String fullname, String email, String phone, String pass, String role) {
        Client client = new Client(fullname, email, phone, pass, role);
        return RunProgramms.appDB.addClient(client);
    }


    @Override
    public Location addLocation(String country, String city) {
        Location location = new Location(country, city);
        return RunProgramms.appDB.addLocation(location);
    }

    @Override
    public Comment replyToComment(long commentID, Comment comment) {
        return null;
    }

    @Override
    public Comment removeComment(long commentID) {
        return null;
    }

    @Override
    public List<Comment> listAllComment() {
        return null;
    }
}
