package com.example.eventmanagementsystem.repository;

import com.example.eventmanagementsystem.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestockOrderRepository extends JpaRepository<RestockOrder, Long> {
}