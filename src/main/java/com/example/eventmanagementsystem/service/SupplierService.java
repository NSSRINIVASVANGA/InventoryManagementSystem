package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.model.*;
import com.example.eventmanagementsystem.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private RestockOrderRepository restockOrderRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void removeSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public RestockOrder createRestockOrder(RestockOrder restockOrder) {
        for (OrderItem orderItem : restockOrder.getOrderItems()) {
            Item item = itemRepository.findById(orderItem.getItem().getId()).orElse(null);
            if (item != null) {
                item.setStockLevel(item.getStockLevel() + orderItem.getQuantity());
                itemRepository.save(item);
            }
        }
        return restockOrderRepository.save(restockOrder);
    }

    public RestockOrder updateRestockOrder(RestockOrder restockOrder) {
        return restockOrderRepository.save(restockOrder);
    }

    public void cancelRestockOrder(Long id) {
        RestockOrder restockOrder = restockOrderRepository.findById(id).orElse(null);
        if (restockOrder != null) {
            for (OrderItem orderItem : restockOrder.getOrderItems()) {
                Item item = itemRepository.findById(orderItem.getItem().getId()).orElse(null);
                if (item != null) {
                    item.setStockLevel(item.getStockLevel() - orderItem.getQuantity());
                    itemRepository.save(item);
                }
            }
            restockOrderRepository.delete(restockOrder);
        }
    }

    public List<RestockOrder> getAllRestockOrders() {
        return restockOrderRepository.findAll();
    }

    public RestockOrder getRestockOrderById(Long id) {
        return restockOrderRepository.findById(id).orElse(null);
    }
}