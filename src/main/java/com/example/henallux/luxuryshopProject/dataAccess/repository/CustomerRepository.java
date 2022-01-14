package com.example.henallux.luxuryshopProject.dataAccess.repository;

import com.example.henallux.luxuryshopProject.dataAccess.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findByUsername(String username);
    CustomerEntity findByEmail(String email);
    Integer countByUsernameOrEmail(String username, String email);
}
