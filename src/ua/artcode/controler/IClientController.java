package ua.artcode.controler;

import ua.artcode.model.*;

import java.util.List;

/**
 * Created by IT on 21.08.2016.
 */
public interface IClientController {

    // создаем клиента
    Client addClient(String email, String fullname, String phone, String pass, String role);

    // создаем компанию
    Company addCompany(String nameCompany, String descriptionCompany, Client client, Location location, List<Service> service);

    //создать заказ
    Order createOrder(Company company, Service service);

    //редактировать заказ
    Order editOrder();

    //закрыть заказ
    //отказаться от заказа
    Order statusOrder();

    //посмотреть свои заказы
    List<Order> listOrders(Client client);

    //поиск сервиса
    String searchService(String serviceName);

    //выбор сервиса
    Service inputService(int serviceId);










}
