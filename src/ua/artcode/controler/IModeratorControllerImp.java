package ua.artcode.controler;

import ua.artcode.db.AppDBImpl;
import ua.artcode.model.*;
import ua.artcode.utils.Constants;
import ua.artcode.utils.DBFileHandler;

import java.util.List;

/**
 * Created by IT on 21.08.2016.
 */
public class IModeratorControllerImp implements IModeratorController {

    private AppDBImpl appDB;
    private DBFileHandler dbFileHandler;

    public IModeratorControllerImp(AppDBImpl appDB, DBFileHandler dbFileHandler) {
        this.appDB = appDB;
        this.dbFileHandler = dbFileHandler;
    }

    @Override
    public Moderator addModerator(String fullname, String email, String phone, String pass, Constants.statusClientRole role, Company company) {
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
        //Worker worker = new Worker(fullName,email,phone,pass, Constants.statusClientRole.WORKER);
      //  return appDB.createWorker(RunProgram.MODERATOR_LOGIN, worker);
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

    @Override
    public Company getCompanyModerator(int moderatroId) {
        return appDB.getCompanyModerator(moderatroId);
    }



}
