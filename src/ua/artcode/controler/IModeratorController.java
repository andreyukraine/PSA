package ua.artcode.controler;

import ua.artcode.model.*;

import java.util.List;

/**
 * Created by serhii on 21.08.16.
 */
public interface IModeratorController {

    // создаем модератора
    Moderator addModerator(String fullname, String email, String phone, String pass, String role);

    // создаем компанию
    Company addCompany(String nameCompany, String descriptionCompany, Client moderator, Location location);

    // изменяем данные про компанию
    Company editCompany(long companyId, String newNameCompany, String newDescriptionCompany, Client moderator, Location location);

    // удаляем компанию
    Company removeCompany(long companyId);

    // ищем компанию
    Company findCompany(long companyId);

    // добавить сервис компании
    Service addServiceToCompany(long companyId, long serviceId);

    //удалить сервис
    Service removeService(long serviceId);

    //создать работника
    Worker createWorker(String fullName, String email, String phone, String pass);

    // добавить сотрудника в компанию
    Worker asignWorkerToModerator(Moderator moderator, Worker worker);

    //передаем заказ в работу сотруднику
    Worker asignOrderWorker(long workerId, Order order);

    // посмотреть всех сотрудников
    List<Worker> getOwnWorkersInCompany(long companyId);

    //назначить сервису работника
    Service asignServiceWorker(long serviceId, Worker worker);

    //удалить сотрудника с компании
    Worker removeWorker(long workerId);

    // редактировать сотрудника
    Worker editWorker(long workerId, String newFullname, String newEmail, String newPhone, String newPass, String newDescriptionWorker);

    // изменить статус заказа
    Order assignStatusOrder(long orderId, int statusIndex);

    //посмотреть всех свободных сотрудников
    List<Worker> showAllFreeWorker(int statusIndex);

    //добавить комментрии

}
