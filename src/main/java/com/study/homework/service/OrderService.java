package com.study.homework.service;

import com.study.homework.pojo.Order;
import com.study.homework.pojo.R;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();

    Order createOrder(long id);

    int updateOrderState(long id, int state);

    Order getOrderById(long id);

    List<Order> getOrdersByCustomerId(long customer_id);
}
