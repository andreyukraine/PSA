package ua.artcode.controler;

import ua.artcode.model.*;

import static ua.artcode.test.controller.IWorkerControllerTest.orders;


/**
 * Created by IT on 22.08.2016.
 */
public class IWorkerControllerImp implements IWorkerController {
    @Override
    public Worker register(String fullname, String email, String phone, String pass, String descriptionWorker) {

        Worker worker = new Worker(fullname, email, phone, pass, descriptionWorker);
        return worker;
    }
//Service --> Service[];
    @Override
    public Service[] myServices(Worker worker) {
       return worker.getServices();

    }

    @Override
    public Order[] ordersWorker(Worker worker) {
        return null;
    }

    @Override
    public Order[] closeOrder(Order order) {
        return new Order[0];
    }
}
