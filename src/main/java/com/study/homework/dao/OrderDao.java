package com.study.homework.dao;

import com.study.homework.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderDao {
    @Select("select * from `order`")
    public List<Order> getOrders();

    @Select("select * from `order` where customer_id = #{customer_id}")
    public List<Order> getOrdersByCustomerId(long customer_id);

    @Select("select * from `order` where id = #{id}")
    public Order getOrderById(long id);

    @Insert("insert into `order` (customer_id) values (#{id})")
    public Order createOrder(long id);

    @Update("update `order` set state = #{state} where id = #{id}")
    public int updateOrderState(long id, int state);
}
