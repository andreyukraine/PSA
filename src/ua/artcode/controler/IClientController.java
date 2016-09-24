package ua.artcode.controler;

import ua.artcode.model.*;
import ua.artcode.utils.Constants;

import java.util.List;
import java.util.Map;

/**
 * Created by IT on 21.08.2016.
 */
public interface IClientController {






    // создаем клиента
    Client addClient(String fullname, String email, String phone, String pass, Constants.StatusClientRole role);

    // удалить
    Client removeClient(long clientId);

    //посмотреть всех клиентов
    Map<String, Client> listAllClient();

    Map<String, Service> listAllService();

    Map<String, Company> listAllCompany();

    //выбор компаний по сервису
    Company getCompanyOfService(String nameService);

    Map<String, Worker> showAllFreeWorker();


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
