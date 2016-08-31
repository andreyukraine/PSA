package ua.artcode.controler;

import ua.artcode.model.*;

/**
 * Created by serhii on 21.08.16.
 */
public interface IModeratorController {

    // @param company without id
    // @return company with id

    // зарегистрация
    //TODO  reducted удалено компанию от модератора
    Moderator register(String fullname, String email, String phone, String pass, String role);

    // создаем компанию
    Company addCompany(String nameCompany, Location location, String descriptionCompany, Moderator moderator);

    // изменяем данные про компанию
    Company editCompany(String nameCompany, String newNameCompany);

    // ищем компанию
    Company findCompany(long companyId);

    // удаляем компанию
    boolean removeCompany(long companyId);

    // добавить сервис компании
    boolean addService(long companyId, Service service);

    //удалить сервис
    boolean removeService(long serviceId);

    //выбрать сервис
    Service[] chooseService(Service ... args);

    Worker createWorker(String fullName, String email, String phone, String pass);

    // добавить сотрудника в компанию
    boolean addWorkerToCompany(long companyId, long workerId);


    //передаем заказ в работу сотруднику
    Worker asignOrderWorker(Order order, long workerId);

    // посмотреть всех сотрудников
    // TODO reduct добавлен параметр компания (посмотреть всех сотрудников в компании)
    Worker[] getOwnWorkersInCompany(long companyId);

    //назначить сервису работника
    //TODO reducted добавлин параметр service и вывод boolean
    boolean asignServiceWorker(Service service, Worker worker);

    //удалить сотрудника с компании
    Worker[] removeWorker(long workerId);

    // редактировать сотрудника
    Worker editWorker(long workerId);

    // изменить статус заказа
    Order assignStatusOrder(Order order, Status status);

    //посмотреть всех свободных сотрудников
    Worker[] showAllFreeWorker(Status status);

}
