package org.itis.gr404.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.itis.gr404.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.awt.image.RescaleOp;
import java.util.List;

/**
 * Created by Регина on 24.04.2016.
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getAllOrders() {
        return sessionFactory.getCurrentSession().createCriteria(Order.class).list();
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    @Transactional
    public void deleteOrder(Order order) {
        sessionFactory.getCurrentSession().delete(order);

    }

    @Override
    public void saveOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order getOrderById(int id) {
        return (Order) sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.eq("id", id)).uniqueResult();
    }
}
