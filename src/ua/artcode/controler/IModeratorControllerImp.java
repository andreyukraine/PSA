package ua.artcode.controler;

import ua.artcode.controler.IModeratorController;
import ua.artcode.model.*;
import ua.artcode.run.RunProgramms;

import java.util.List;

/**
 * Created by IT on 21.08.2016.
 */
public class IModeratorControllerImp implements IModeratorController {

    @Override
    public Moderator addModerator(String fullname, String email, String phone, String pass, String role) {
        Moderator moderator= new Moderator(fullname, email, phone, pass, role);
        return RunProgramms.appDB.addModerator(moderator);
    }

    @Override
    public Company addCompany(String nameCompany, String descriptionCompany, Client moderator,Location location ) {
        Company company = new Company(nameCompany,descriptionCompany,moderator,location);
        return RunProgramms.appDB.addCompany(company);
    }

    @Override
    public Company editCompany(long companyId, String newNameCompany, String newDescriptionCompany, Client moderator, Location location) {
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
        return RunProgramms.appDB.createWorker(worker);
    }

    @Override
    public Worker asignWorkerToModerator(Moderator moderator, Worker worker) {
        return null;
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
