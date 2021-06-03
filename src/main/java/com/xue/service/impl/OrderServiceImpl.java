package com.xue.service.impl;

import com.xue.mapper.OrderMapper;
import com.xue.mapper.UserMapper;
import com.xue.pojo.Order;
import com.xue.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(Order order) {
        return orderMapper.add(order);
    }

    @Override
    public int delete(int id) {
        return orderMapper.delete(id);
    }

    @Override
    public int update(Order order) {
        return orderMapper.update(order);
    }

    @Override
    public List<Order> list() {
        List<Order> orders = orderMapper.list();
        for (Order o : orders) {
            o.setUser(userMapper.get(o.getUid()));
        }
        return orders;
    }

    @Override
    public Order getOrderById(int id) {
        return orderMapper.getOrderById(id);
    }
}
