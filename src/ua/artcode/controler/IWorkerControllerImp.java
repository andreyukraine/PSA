package ua.artcode.controler;

import ua.artcode.db.AppDBImpl;
import ua.artcode.model.*;
import ua.artcode.utils.Constants;
import ua.artcode.utils.DBFileHandler;

import java.util.List;


/**
 * Created by IT on 22.08.2016.
 */
public class IWorkerControllerImp implements IWorkerController {

    private AppDBImpl appDB;
    private DBFileHandler dbFileHandler;

    public IWorkerControllerImp() {
    }

    public IWorkerControllerImp(AppDBImpl appDB, DBFileHandler dbFileHandler) {
        this.appDB = appDB;
        this.dbFileHandler = dbFileHandler;
    }

    @Override
    public Worker addWorker(String fullname, String email, String phone, String pass) {
        Worker worker = new Worker(fullname, email, phone, pass, Constants.statusClientRole.WORKER);
        return worker;
    }

    @Override
    public Worker editWorker(long workerId, String newFullname, String newEmail, String newPhone, String newPass, String newDescriptionWorker) {
        return null;
    }

    @Override
    public List<Worker> myServices(Worker worker) {
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
    public List<Order> ordersWorker(Worker worker) {
        return null;
    }

    @Override
    public Order closeOrder(Order order) {
        return null;
    }

    @Override
    public List<Worker> getOwnWorkersInCompany(long companyId) {
        return null;
    }

    @Override
    public List<Worker> showAllFreeWorker(int statusIndex) {
        return null;
    }

}
