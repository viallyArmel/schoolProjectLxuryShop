package com.example.henallux.luxuryshopProject.dataAccess.dao;

import com.example.henallux.luxuryshopProject.model.Customer;

import java.util.ArrayList;

public interface CustomerDataAccess {
    ArrayList<Customer> getAllCustomers();
    Customer save(Customer customer);
    Customer findByUsername(String username);
    Boolean customerAlreadyExists(String username, String email);
}
