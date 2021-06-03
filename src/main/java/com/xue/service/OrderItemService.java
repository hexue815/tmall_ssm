package com.xue.service;

import com.xue.pojo.Order;
import com.xue.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemService {
    int add(OrderItem orderItem);

    int delete(int id);

    int update(OrderItem orderItem);

    List<OrderItem> list();

    OrderItem getOrderItemById(int id);

    List<OrderItem> getOrderItemByOid(int oid);

    void fill(List<Order> orders);

    void fill(Order order);
}
