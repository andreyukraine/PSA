package ua.artcode.controler;

import ua.artcode.model.Order;
import ua.artcode.model.Worker;

/**
 * Created by IT on 08.09.2016.
 */
public interface IOrder {


    // изменить статус заказа
    Order assignStatusOrder(long orderId, int statusIndex);

    //передаем заказ в работу сотруднику
    Worker asignOrderWorker(long workerId, Order order);


}
