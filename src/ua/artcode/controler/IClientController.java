package ua.artcode.controler;

import ua.artcode.model.*;

/**
 * Created by IT on 21.08.2016.
 */
public interface IClientController {

    // зарегистрирация
    User register(String email, String fullname, String phone, String pass, String role);

    //поиск сервиса
    Service[] searchService();

    //создать заказ
    Order createOrder(Company company, Service service);

    //редактировать заказ
    Order editOrder();

    //закрыть заказ
    Order closeOrder();

    //посмотреть свои заказы
    Order[] listOrders(User user, Status status);



    //оставить комментарий сервису
    Comment addCommentService (Service service);

    //оставить комментарий компании
    Comment addCommentCompany (Company company);

    //оставить комментарий сотруднику
    Comment addCommentWorker (Worker worker);

    //оставить комментарий про систему
    Comment addCommentPSA();

}
