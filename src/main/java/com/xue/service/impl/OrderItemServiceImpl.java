package com.xue.service.impl;

import com.xue.mapper.OrderItemMapper;
import com.xue.pojo.Order;
import com.xue.pojo.OrderItem;
import com.xue.service.OrderItemService;
import com.xue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public int add(OrderItem orderItem) {
        return orderItemMapper.add(orderItem);
    }

    @Override
    public int delete(int id) {
        return orderItemMapper.delete(id);
    }

    @Override
    public int update(OrderItem orderItem) {
        return orderItemMapper.update(orderItem);
    }

    @Override
    public List<OrderItem> list() {
        List<OrderItem> orderItems = orderItemMapper.list();
        for (OrderItem oi :
                orderItems) {
            oi.setProduct(productService.getProductByID(oi.getPid()));
        }
        return orderItems;
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        OrderItem orderItem = orderItemMapper.getOrderItemById(id);
        orderItem.setProduct(productService.getProductByID(orderItem.getPid()));
        return orderItem;
    }

    @Override
    public List<OrderItem> getOrderItemByOid(int oid) {
        return orderItemMapper.getOrderItemByOid(oid);
    }

    @Override
    public void fill(List<Order> orders) {
        for (Order order : orders) {
            fill(order);
        }
    }

    @Override
    public void fill(Order order) {
        float total = 0;
        int totalNumber = 0;
        // 根据订单oid查询orderItems
        List<OrderItem> orderItems = orderItemMapper.getOrderItemByOid(order.getId());
        // 依次设置product属性,并计算总价格和全部数量
        for (OrderItem oi : orderItems) {
            oi.setProduct(productService.getProductByID(oi.getPid()));
            total += oi.getNumber() * oi.getProduct().getPromotePrice();
            totalNumber += oi.getNumber();
        }

        order.setTotal(total);
        order.setTotalNumber(totalNumber);
        order.setOrderItems(orderItems);

    }


}






























