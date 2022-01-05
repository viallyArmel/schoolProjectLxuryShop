package com.example.henallux.luxuryshopProject.dataAccess.repository;

import com.example.henallux.luxuryshopProject.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
