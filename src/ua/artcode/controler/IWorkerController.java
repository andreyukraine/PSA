package ua.artcode.controler;

import ua.artcode.model.*;

import java.util.List;

/**
 * Created by IT on 21.08.2016.
 */
public interface IWorkerController {

    //регистрация
    Worker addWorker(String fullname, String email, String phone, String pass);

    // редактировать сотрудника
    Worker editWorker(long workerId, String newFullname, String newEmail, String newPhone, String newPass, String newDescriptionWorker);

    //посмотреть все закрепленные сервисы
    List<Worker> myServices(Worker worker);

    //назначить сервису работника
    Service asignServiceWorker(long serviceId, Worker worker);

    //удалить сотрудника с компании
    Worker removeWorker(long workerId);

    //заказы сотрудника
    List<Order> ordersWorker(Worker worker);

    //закрыть заказ
    Order closeOrder(Order order);

    // посмотреть всех сотрудников
    List<Worker> getOwnWorkersInCompany(long companyId);

    //посмотреть всех свободных сотрудников
    List<Worker> showAllFreeWorker(int statusIndex);

}
