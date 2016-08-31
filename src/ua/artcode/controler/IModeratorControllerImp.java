package ua.artcode.controler;

import ua.artcode.controler.IModeratorController;
import ua.artcode.model.*;
import ua.artcode.run.RunProgramms;

import java.util.List;

/**
 * Created by IT on 21.08.2016.
 */
public class IModeratorControllerImp implements IModeratorController {

    List<Service> services;
    List<Company> companies;
    List<Client> clients;

    //TODO  reducted удалено компанию от модератора
    @Override
    public Moderator register(String fullname, String email, String phone, String pass, String role) {
        Moderator moderator= new Moderator(fullname, email, phone, pass, role);
        return moderator;
    }

    //TODO  reducted  изменено create на add
    @Override
    public Company addCompany(String nameCompany, Location location, String descriptionCompany, Moderator moderator) {
        Company company = new Company(nameCompany,location,descriptionCompany,moderator);
        return RunProgramms.appDB.addCompany(company);
    }

    @Override
    public Company editCompany(String nameCompany, String newNameCompany) {
        return null;
    }

    @Override
    public Company findCompany(long companyId) {
        return null;
    }

    @Override
    public boolean removeCompany(long companyId) {
        return false;
    }

    @Override
    public boolean addService(long companyId, Service service) {
        return false;
    }

    @Override
    public boolean removeService(long serviceId) {
        return false;
    }

    @Override
    public Service[] chooseService(Service ... args) {
        Service[] chooseArrayService = new Service[args.length];
        return chooseArrayService;
    }

    public Worker createWorker(String fullName, String email, String phone, String pass){
       return null;
    }

    @Override
    public boolean addWorkerToCompany(long companyId, long workerId) {
        return false;
    }

    @Override
    public Worker asignOrderWorker(Order order, long workerId) {
        return null;
    }



    @Override
    public Worker[] getOwnWorkersInCompany(long companyId) {
        return null;
    }



    @Override
    public boolean asignServiceWorker(Service service, Worker worker) {
        return false;
    }

    @Override
    public Worker[] removeWorker(long workerId) {
        return new Worker[0];
    }

    @Override
    public Worker editWorker(long workerId) {
        return null;
    }



    @Override
    public Order assignStatusOrder(Order order, Status status) {
        return null;
    }

    @Override
    public Worker[] showAllFreeWorker(Status status) {
        return new Worker[0];
    }
}
