package com.example.eventmanagementsystem.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonBackReference("order-orderItems")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "restock_order_id")
    @JsonBackReference("restockOrder-orderItems")
    private RestockOrder restockOrder;

    public OrderItem() {
    }

    public OrderItem(Long id, Order order, Item item, int quantity) {
        this.id = id;
        this.order = order;
        this.item = item;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public RestockOrder getRestockOrder() {
        return restockOrder;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRestockOrder(RestockOrder restockOrder) {
        this.restockOrder = restockOrder;
    }
}