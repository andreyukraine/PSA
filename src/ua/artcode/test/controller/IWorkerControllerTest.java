package ua.artcode.test.controller;

import ua.artcode.controler.IWorkerController;
import ua.artcode.controler.IWorkerControllerImp;
import ua.artcode.model.Client;
import ua.artcode.model.Order;
import ua.artcode.model.Service;

import ua.artcode.model.Worker;


/**
 * Created by IT on 22.08.2016.
 */
public class IWorkerControllerTest {

    static IWorkerController iWorkerController = new IWorkerControllerImp();
    public static Service[] services = new Service[10];
    public static Worker[] workers = new Worker[10];
    public static Order[] orders = new Order[10];

    public static void main(String[] args) {

        Worker worker = new Worker("Lada", "@gmail", "+380", "123457", "molodetc");

        workers[0] = worker;

        Service service = new Service("CutWood", "Hydystch");
        Service service1 = new Service("CutWood1", "Hydystch");
        Service service2 = new Service("CutWood2", "Hydystch");
        Service service3 = new Service("CutWood3", "Hydystch");
        Service service4 = new Service("CutWood4", "Hydystch");

        services[0] = service;
        services[1] = service1;
        services[2] = service2;
        services[3] = service3;
        services[4] = service4;

        service.setWorkers(workers);

        Client client = new Client("Gena", "krokodil@mail.ru", "245", "cheburashka", "client");
        Order order = new Order(10, service, client, "cut surrouded trees");
        orders[0] = order;
        //worker.setOrders(orders);


//        registerTest(worker.getFullname(), worker.getEmail(), worker.getPhone(),
//                worker.getPass(), worker.getDescriptionWorker(), worker);


    }

//    static boolean registerTest(String fullname, String email, String phone, String pass,
//                                String descriptionWorker, Worker worker1) {
//
//        Worker worker = iWorkerController.register(fullname, email, phone, pass, descriptionWorker);
//
//        boolean booleanCheck = worker.getFullname().equals(worker1.getFullname());
//
//        System.out.printf("res %s, method %s, ex %s = practical %s\n",
//                booleanCheck, "registerTest", worker1.getFullname(), worker.getFullname());
//
//        return booleanCheck;
//    }


}


