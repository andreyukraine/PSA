package ua.artcode.utils;

/**
 * Created by serhii on 04.09.16.
 */
public final class Constants {

    private Constants(){}

    // todo extract from a properties file
    public static final String DB_PATH = "mydb.txt";
    public static final String DB_PATH_JSON = "mydb.json";
    public static final Integer VIEW_HIGHT = 250;
    public static final Integer VIEW_WIDTH = 650;


    //статус компании
    public enum StatusCompany {
        NEW,
        IN_PROGRESS,
        DONE;
    }

    //роли сервиса PSA
    public enum StatusClientRole {
        MODERATOR_PSA,
        MODERATOR,
        WORKER,
        CLIENT;
    }

    //статусы заказа
    public enum StatusOrder {
        NEW,
        IN_PROGRESS,
        DONE;
    }

    //статус работника
    public enum StatusWorker {
        FREE,
        BUSY;
    }


}
