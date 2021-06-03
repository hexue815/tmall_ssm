package com.xue.mapper;

import com.xue.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    int add(OrderItem orderItem);

    int delete(@Param("id") int id);

    int update(OrderItem orderItem);

    List<OrderItem> list();

    OrderItem getOrderItemById(@Param("id") int id);

    List<OrderItem> getOrderItemByOid(int oid);
}
