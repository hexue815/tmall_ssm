package com.xue.mapper;

import com.xue.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int add(Order order);

    int delete(@Param("id") int id);

    int update(Order order);

    List<Order> list();

    Order getOrderById(@Param("id") int id);
}
