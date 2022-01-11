package com.example.henallux.luxuryshopProject.dataAccess.repository;

import com.example.henallux.luxuryshopProject.dataAccess.entity.CustomerEntity;
import com.example.henallux.luxuryshopProject.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    Integer countOrderEntityByCustomer(CustomerEntity customer);
    // List<OrderEntity> findByCustomerId(Integer id);
}
