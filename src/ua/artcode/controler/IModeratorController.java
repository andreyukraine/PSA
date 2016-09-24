package ua.artcode.controler;

import ua.artcode.model.*;
import ua.artcode.utils.Constants;

/**
 * Created by serhii on 21.08.16.
 */
public interface IModeratorController {

    // создаем модератора
    Moderator addModerator(String fullname, String email, String phone, String pass, Constants.StatusClientRole role);

    // добавить сервис компании
    Service addServiceToCompany(long companyId, long serviceId);

    Company getCompanyModerator(int moderatroId);

}
