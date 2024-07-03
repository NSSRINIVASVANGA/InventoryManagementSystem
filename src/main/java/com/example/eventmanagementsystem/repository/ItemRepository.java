package com.example.eventmanagementsystem.repository;

import com.example.eventmanagementsystem.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}