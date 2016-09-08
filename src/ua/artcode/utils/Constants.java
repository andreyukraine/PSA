package ua.artcode.utils;

/**
 * Created by serhii on 04.09.16.
 */
public final class Constants {

    private Constants(){}

    public static final String DB_PATH = "mydb.txt";
    public static final String DB_PATH_JSON = "mydb.json";

    //статус компании
    public static enum statusCompany{
        NEW,
        IN_PROGRESS,
        DONE;
    }

    //роли сервиса PSA
    public static enum statusClientRole {
        MODERATOR_PSA,
        MODERATOR,
        WORKER,
        CLIENT;
    }

    //статусы заказа
    public static enum statusOrder{
        NEW,
        IN_PROGRESS,
        DONE;
    }

    //статус работника

    //-free
    //-busy

    //статус заказа

    //-new
    //-in progress
    //-closed
    //-refused

}
