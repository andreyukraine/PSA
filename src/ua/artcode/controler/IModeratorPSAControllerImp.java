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


    public ModeratorPSA addModeratorPSA(String fullname, String email, String phone, String pass, String role){
        ModeratorPSA moderatorPSA = new ModeratorPSA(fullname,email,phone,pass,role);
        return RunProgramms.appDB.addModeratorPSA(moderatorPSA);
    }

    @Override
    public Service addService(String nameService, String descriptionService) {
        Service service = new Service(nameService,descriptionService);
        return RunProgramms.appDB.addService(service);
    }

    public String removeService(long serviceId) {
        return   RunProgramms.appDB.removeService(serviceId);
    }

    public String editService(long serviceId, String newNameService, String newDescriptionService) {
       return RunProgramms.appDB.editService(serviceId, newNameService, newDescriptionService);
    }


    public Company changeStatusCompany(long companyId, int status) {
        return  null;
    }

    @Override
    public Company addCompany(String nameCompany, String descriptionCompany, Client moderator, Location location) {
        Company company = new Company(nameCompany,descriptionCompany,moderator,location);
        return RunProgramms.appDB.addCompany(company);
    }

    @Override
    public Company removeCompany(long companyId) {
        return null;
    }

    @Override
    public Client removeClient(long clientId) {
        return null;
    }

    @Override
    public List<Company> listAllCompany() {
        return null;
    }

    @Override
    public List<Client> listAllClient() {
        return null;
    }

    @Override
    public List<Service> listAllService() {
        return null;
    }

    @Override
    public List<Client> listAllModerator() {
        return null;
    }

    public Client addClient(String fullname, String email, String phone, String pass, String role) {
        Client client = new Client(fullname,email,phone,pass,role);
        return RunProgramms.appDB.addClient(client);
    }


    @Override
    public Location addLocation(String country, String city) {
        Location location = new Location(country,city);
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
