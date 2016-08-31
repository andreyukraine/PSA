package ua.artcode.model;

/**
 * Created by IT on 21.08.2016.
 */
public class Status {


    //статус работника

        //-free
        //-busy

    //статус заказа

        //-new
        //-in progress
        //-closed
        //-refused

    //статус компании
    public String statusCompany(int statusIndex){
        switch (statusIndex){
            case 1:
                return "NEW";
            case 2:
                return "IN_PROGRESS";
            case 3:
                return "DONE";
            default:
                return "UknownNow";
        }
    }
    //роли сервиса PSA
public String statusUserRole(int statusIndex){
    switch (statusIndex){
        case 1:
            return "moderatorPSA";
        case 2:
            return "moderator";
        case 3:
            return "worker";
        case 4:
            return "client";
        default:
            return "UknownNow";
    }
}
        //-moderatorPSA
        //-moderatorCompany
        //-user
        //-worker
}
