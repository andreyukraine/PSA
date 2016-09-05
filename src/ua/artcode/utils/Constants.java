package ua.artcode.utils;

/**
 * Created by serhii on 04.09.16.
 */
public final class Constants {

    private Constants(){}

    public static final String DB_PATH = "mydb.txt";

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
}
