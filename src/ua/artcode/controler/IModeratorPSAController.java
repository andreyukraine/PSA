package ua.artcode.controler;
import ua.artcode.model.*;

/**
 * Created by IT on 21.08.2016.
 */
public interface IModeratorPSAController {

    //регистрация
    ModeratorPSA register(String fullname, String email, String phone, String pass, String role);

    //добавить сервис
    Service addService(String nameService, String descriptionService);

    //удалить сервис
    String removeService(long serviceId);

    //редактировать сервис
    String editService(long serviceId, String newNameService, String newDescriptionService);

    //подтвердить/отказать добавление компании
    Company changeStatusCompany(long companyId, int status);

    //удалить компанию
    Company[] removeCompany(long companyId);

    //ответить на коментарий сервиса PSA
    Comment replyToComment(long commentID, Comment comment);

    //удалить комментарий сервиса PSA
    Comment removeComment(long commentID);

    //добавить пользователя
    Client addClient(String fullname, String email, String phone, String pass, String role);

    //изменить пользователя
    User[] editUser(long userId, User user);

    //удалить пользователя
    User[] removeUser(long userId);

    //посмотреть все компании
    Company[] listAllCompany();

    //посмотреть все сервисы
    Service[] listAllService();


}
