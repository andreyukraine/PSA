package ua.artcode.controler;
import ua.artcode.exceptions.AppException;
import ua.artcode.exceptions.ModeratorExeption;
import ua.artcode.model.*;
import ua.artcode.utils.Constants;

import java.util.Map;

/**
 * Created by IT on 21.08.2016.
 */
public interface IModeratorPSAController {

    //создать модератора пса
    ModeratorPSA addModeratorPSA(String fullname, String email, String phone, String pass, Constants.StatusClientRole role);

    //посмотреть всех модераторов
    Map<String, Moderator> listAllModerator() throws ModeratorExeption;

    //добавить локацию
    Location addLocation(String country, String city);

    void saveAllToDb() throws AppException;

    void loadAllFromDb() throws AppException;

    String dbToJson() throws AppException;



}
