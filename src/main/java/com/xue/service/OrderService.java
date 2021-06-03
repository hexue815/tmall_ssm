package com.xue.service;

import com.xue.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

    int add(Order order);

    int delete(int id);

    int update(Order order);

    List<Order> list();

    Order getOrderById(int id);
}
