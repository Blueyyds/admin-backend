package com.study.homework.service.impl;

import com.study.homework.dao.OrderDao;
import com.study.homework.pojo.Order;
import com.study.homework.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    public Order createOrder(long id) {
        return orderDao.createOrder(id);
    }

    public int updateOrderState(long id, int state) {
        return orderDao.updateOrderState(id, state);
    }

    public Order getOrderById(long id) {
        return orderDao.getOrderById(id);
    }

    public List<Order> getOrdersByCustomerId(long customer_id) {
        return orderDao.getOrdersByCustomerId(customer_id);
    }
}
