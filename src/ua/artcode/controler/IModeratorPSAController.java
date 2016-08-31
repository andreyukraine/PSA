package ua.artcode.controler;
import ua.artcode.model.*;

import java.util.List;

/**
 * Created by IT on 21.08.2016.
 */
public interface IModeratorPSAController {

    //создать модератора пса
    ModeratorPSA addModeratorPSA(String fullname, String email, String phone, String pass, String role);

    //добавить сервис
    Service addService(String nameService, String descriptionService);

    //удалить сервис
    String removeService(long serviceId);

    //редактировать сервис
    String editService(long serviceId, String newNameService, String newDescriptionService);

    //подтвердить/отказать добавление компании
    Company changeStatusCompany(long companyId, int statusIndex);


    //убрать добавление компании
    //добавить компанию
    Company addCompany(String nameCompany, String descriptionCompany, Client moderator, Location location);

    //удалить компанию
    Company removeCompany(long companyId);

    //удалить пользователя
    Client removeClient(long clientId);

    //посмотреть все компании
    List<Company> listAllCompany();

    //посмотреть всех клиентов
    List<Client> listAllClient();

    //посмотреть все сервисы
    List<Service> listAllService();

    //посмотреть всех модераторов
    List<Client> listAllModerator();

    //добавить локацию
    Location addLocation(String country, String city);

    //ответить на коментарий сервиса PSA
    Comment replyToComment(long commentID, Comment comment);

    //удалить комментарий сервиса PSA
    Comment removeComment(long commentID);

    //посмотреть комментарии сервиса PSA
    List<Comment> listAllComment();


}
