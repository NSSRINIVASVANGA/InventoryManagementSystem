package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.*;
import com.example.eventmanagementsystem.service.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public Supplier addSupplier(@RequestBody Supplier supplier) {
        return supplierService.addSupplier(supplier);
    }

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        supplier.setId(id);
        return supplierService.updateSupplier(supplier);
    }

    @DeleteMapping("/{id}")
    public void removeSupplier(@PathVariable Long id) {
        supplierService.removeSupplier(id);
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

    @PostMapping("/restock-orders")
    public RestockOrder createRestockOrder(@RequestBody RestockOrder restockOrder) {
        return supplierService.createRestockOrder(restockOrder);
    }

    @PutMapping("/restock-orders/{id}")
    public RestockOrder updateRestockOrder(@PathVariable Long id, @RequestBody RestockOrder restockOrder) {
        restockOrder.setId(id);
        return supplierService.updateRestockOrder(restockOrder);
    }

    @DeleteMapping("/restock-orders/{id}")
    public void cancelRestockOrder(@PathVariable Long id) {
        supplierService.cancelRestockOrder(id);
    }

    @GetMapping("/restock-orders")
    public List<RestockOrder> getAllRestockOrders() {
        return supplierService.getAllRestockOrders();
    }

    @GetMapping("/restock-orders/{id}")
    public RestockOrder getRestockOrderById(@PathVariable Long id) {
        return supplierService.getRestockOrderById(id);
    }
}