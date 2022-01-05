package com.example.henallux.luxuryshopProject.dataAccess.repository;

import com.example.henallux.luxuryshopProject.dataAccess.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Integer> {
}
