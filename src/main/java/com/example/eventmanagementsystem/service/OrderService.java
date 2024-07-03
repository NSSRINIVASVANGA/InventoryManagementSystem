package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.model.*;
import com.example.eventmanagementsystem.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Order createOrder(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            Item item = itemRepository.findById(orderItem.getItem().getId()).orElse(null);
            if (item != null) {
                item.setStockLevel(item.getStockLevel() - orderItem.getQuantity());
                itemRepository.save(item);
            }
        }
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            for (OrderItem orderItem : order.getOrderItems()) {
                Item item = itemRepository.findById(orderItem.getItem().getId()).orElse(null);
                if (item != null) {
                    item.setStockLevel(item.getStockLevel() + orderItem.getQuantity());
                    itemRepository.save(item);
                }
            }
            orderRepository.delete(order);
        }
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}