package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.*;
import com.example.eventmanagementsystem.service.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/reports")
public class ReportingController {
    @Autowired
    private ReportingService reportingService;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return reportingService.getAllItems();
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return reportingService.getAllOrders();
    }

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers() {
        return reportingService.getAllSuppliers();
    }

    @GetMapping("/restock-orders")
    public List<RestockOrder> getAllRestockOrders() {
        return reportingService.getAllRestockOrders();
    }
}