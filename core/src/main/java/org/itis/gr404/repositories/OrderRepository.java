package org.itis.gr404.repositories;

import org.itis.gr404.entities.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Regina on 11.04.2016.
 */
@Repository
public interface OrderRepository {

    public List<Order> getAllOrders();

    public void updateOrder(Order order);

    public void deleteOrder(Order order);

    public void saveOrder(Order order);

    public Order getOrderById(int id);

}
