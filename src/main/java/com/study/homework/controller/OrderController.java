package com.study.homework.controller;

import com.study.homework.pojo.Order;
import com.study.homework.pojo.R;
import com.study.homework.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/get")
    public R getAllOrders() {
        List<Order> orderList = orderService.getOrders();
        System.out.println(orderList);
        if (orderList.size() >= 0) {
            return new R(20000, "获取所有订单成功", orderList);
        } else {
            return new R(7, "获取所有订单失败", null);
        }
    }

    @GetMapping("/getOrderByCustomerId")
    public R getOrderByCustomerId(long customer_id){
        List<Order> orderList = orderService.getOrdersByCustomerId(customer_id);
        return new R(20000, "获取订单成功", orderList);
    }

    @PutMapping("/updateState")
    public R updateOrderState(@RequestParam long id, @RequestParam int state) {
        int res = orderService.updateOrderState(id, state);
        if (res == 1) {
            Order o = orderService.getOrderById(id);
            return new R(20000, "更新订单状态成功", o);
        } else {
            return new R(7, "更新订单状态失败", null);
        }
    }
}
