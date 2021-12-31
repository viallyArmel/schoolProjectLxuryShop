package com.example.henallux.luxuryshopProject.dataAccess.dao;

import com.example.henallux.luxuryshopProject.dataAccess.entity.CustomerEntity;
import com.example.henallux.luxuryshopProject.dataAccess.repository.CustomerRepository;
import com.example.henallux.luxuryshopProject.dataAccess.util.ProviderConverter;
import com.example.henallux.luxuryshopProject.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerDAO implements CustomerDataAccess{
    private CustomerRepository customerRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CustomerDAO(CustomerRepository customerRepository, ProviderConverter providerConverter){
        this.customerRepository = customerRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Customer save(Customer customer){
        CustomerEntity entity = providerConverter.userModelToUserEntity(customer);
        entity = customerRepository.save(entity);
        return providerConverter.customerEntityToCustomer(entity);
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        List<CustomerEntity> entities = customerRepository.findAll();
        ArrayList<Customer> customers = new ArrayList<>();

        for (CustomerEntity entity : entities){
            customers.add(providerConverter.customerEntityToCustomer(entity));
        }
        return customers;
    }

    public Customer findByUsername(String username){
        CustomerEntity customerEntity = customerRepository.findByUsername(username);
        return providerConverter.customerEntityToCustomer(customerEntity);
    }

    @Override
    public Boolean customerAlreadyExist(Customer customer) {

        CustomerEntity customerEntity = providerConverter.userModelToUserEntity(customer);
        Example <CustomerEntity> exampleEntity  = Example.of(customerEntity);
        return customerRepository.exists(exampleEntity);
    }

    @Override
    public Boolean countByUsernameAndEmail(String username, String email) {
        return customerRepository.countByUsernameAndEmail(username, email) > 0;
    }
}
