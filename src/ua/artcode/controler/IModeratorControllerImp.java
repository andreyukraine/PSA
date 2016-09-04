package ua.artcode.controler;

import ua.artcode.controler.IModeratorController;
import ua.artcode.db.IAppDB;
import ua.artcode.model.*;
import ua.artcode.run.RunProgramms;

import java.util.List;

import static ua.artcode.run.RunProgramms.appDB;
import static ua.artcode.run.RunProgramms.appJSON;

/**
 * Created by IT on 21.08.2016.
 */
public class IModeratorControllerImp implements IModeratorController {

    private IAppDB iAppDB;

    @Override
    public Moderator addModerator(String fullname, String email, String phone, String pass, String role) {
        Moderator moderator= new Moderator(fullname, email, phone, pass, role, null);
        return appDB.addModerator(moderator);
    }

    @Override
    public Company addCompany(String nameCompany, String descriptionCompany, Client client, Location location, List<Service> service ) {
        Company company = new Company(nameCompany,descriptionCompany,client,location, service);
        return appDB.addCompany(company);
    }

    @Override
    public Company editCompany(long companyId, String newNameCompany, String newDescriptionCompany, Moderator moderator, Location location) {
        return null;
    }

    @Override
    public Company removeCompany(long companyId) {
        return null;
    }

    @Override
    public Company findCompany(long companyId) {
        return null;
    }

    @Override
    public Service addServiceToCompany(long companyId, long serviceId) {
        return null;
    }

    @Override
    public Service removeService(long serviceId) {
        return null;
    }

    @Override
    public Worker createWorker(String fullName, String email, String phone, String pass) {
        Worker worker = new Worker(fullName,email,phone,pass,new Status().statusClientRole(3));
        return appDB.createWorker(RunProgramms.MODERATOR_LOGIN, worker);
    }

    @Override
    public Worker asignOrderWorker(long workerId, Order order) {
        return null;
    }

    @Override
    public List<Worker> getOwnWorkersInCompany(long companyId) {
        return null;
    }

    @Override
    public Service asignServiceWorker(long serviceId, Worker worker) {
        return null;
    }

    @Override
    public Worker removeWorker(long workerId) {
        return null;
    }

    @Override
    public Worker editWorker(long workerId, String newFullname, String newEmail, String newPhone, String newPass, String newDescriptionWorker) {
        return null;
    }

    @Override
    public Order assignStatusOrder(long orderId, int statusIndex) {
        return null;
    }

    @Override
    public List<Worker> showAllFreeWorker(int statusIndex) {
        return null;
    }


}
