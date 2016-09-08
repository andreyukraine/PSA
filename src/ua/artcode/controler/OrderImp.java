package ua.artcode.controler;

import ua.artcode.db.AppDBImpl;
import ua.artcode.model.Order;
import ua.artcode.model.Worker;
import ua.artcode.utils.DBFileHandler;

/**
 * Created by IT on 08.09.2016.
 */
public class OrderImp implements IOrder {

    private AppDBImpl appDB;
    private DBFileHandler dbFileHandler;

    public OrderImp() {
    }


    public OrderImp(AppDBImpl appDB, DBFileHandler dbFileHandler) {
        this.appDB = appDB;
        this.dbFileHandler = dbFileHandler;
    }


    @Override
    public Order assignStatusOrder(long orderId, int statusIndex) {
        return null;
    }

    @Override
    public Worker asignOrderWorker(long workerId, Order order) {
        return null;
    }
}
