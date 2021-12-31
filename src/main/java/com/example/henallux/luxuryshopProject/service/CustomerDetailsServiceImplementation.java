package com.example.henallux.luxuryshopProject.service;

import com.example.henallux.luxuryshopProject.dataAccess.dao.CustomerDAO;
import com.example.henallux.luxuryshopProject.dataAccess.dao.CustomerDataAccess;
import com.example.henallux.luxuryshopProject.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsServiceImplementation implements UserDetailsService {

    private CustomerDataAccess customerDataAccess;

    @Autowired
    public CustomerDetailsServiceImplementation (CustomerDAO customerDAO){
        this.customerDataAccess = customerDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerDataAccess.findByUsername(s);
        if (customer != null)
            return customer;
        throw new UsernameNotFoundException("Customer not found !");
    }

}
