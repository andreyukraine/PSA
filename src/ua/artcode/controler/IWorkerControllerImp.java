package ua.artcode.controler;

import ua.artcode.model.*;

import java.util.List;

import static ua.artcode.test.controller.IWorkerControllerTest.orders;


/**
 * Created by IT on 22.08.2016.
 */
public class IWorkerControllerImp implements IWorkerController {
    @Override
    public Worker addWorker(String fullname, String email, String phone, String pass, String descriptionWorker) {
        Worker worker = new Worker(fullname, email, phone, pass, descriptionWorker);
        return worker;
    }

    @Override
    public List<Worker> myServices(Worker worker) {
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

}
