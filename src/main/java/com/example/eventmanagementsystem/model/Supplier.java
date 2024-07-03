package com.example.eventmanagementsystem.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "contact_info")
    private String contactInfo;
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RestockOrder> restockOrders;

    public Supplier() {
    }

    public Supplier(Long id, String name, String contactInfo, List<RestockOrder> restockOrders) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.restockOrders = restockOrders;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<RestockOrder> getRestockOrders() {
        return restockOrders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setRestockOrders(List<RestockOrder> restockOrders) {
        this.restockOrders = restockOrders;
    }
}