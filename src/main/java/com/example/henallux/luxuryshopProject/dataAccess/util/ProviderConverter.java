package com.example.henallux.luxuryshopProject.dataAccess.util;

import com.example.henallux.luxuryshopProject.dataAccess.entity.CategoryEntity;
import com.example.henallux.luxuryshopProject.dataAccess.entity.CustomerEntity;
import com.example.henallux.luxuryshopProject.dataAccess.entity.ProductEntity;
import com.example.henallux.luxuryshopProject.model.Category;
import com.example.henallux.luxuryshopProject.model.Customer;
import com.example.henallux.luxuryshopProject.model.Product;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {
    private Mapper mapper = new DozerBeanMapper();
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public Customer customerEntityToCustomer(CustomerEntity customerEntity){
        Customer customer = mapper.map(customerEntity, Customer.class);
        customer.setAccountNonExpired(customerEntity.getAccountNonExpired());
        customer.setAccountNonLocked(customerEntity.getAccountNonLocked());
        customer.setCredentialsNonExpired(customerEntity.getCredentialsNonExpired());
        customer.setEnabled(customerEntity.getEnabled());
        customer.setAuthorities(customerEntity.getAuthorities());

        return customer;
    }

    public CustomerEntity userModelToUserEntity(Customer customer){
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        customerEntity.setFirstName(customer.getFirstname());
        customerEntity.setLastName(customer.getLastname());
        customerEntity.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customerEntity.setAccountNonExpired(customer.isAccountNonExpired());
        customerEntity.setAccountNonLocked(customer.isAccountNonLocked());
        customerEntity.setCredentialsNonExpired(customer.isCredentialsNonExpired());
        customerEntity.setEnabled(customer.isEnabled());
        customerEntity.setAuthorities("USER");

        return customerEntity;
    }

    public Product productEntityToProduct(ProductEntity productEntity){
        Product product = mapper.map(productEntity, Product.class);
        Category category = categoryEntityToCategory(productEntity.getCategory());
        product.setOutOfStock(productEntity.getOut_of_stock());
        product.setCategory(category);
        return product;
    }

    public ProductEntity productToProductEntity(Product product){
        return mapper.map(product, ProductEntity.class);
    }

    public Category categoryEntityToCategory(CategoryEntity categoryEntity){
        return mapper.map(categoryEntity, Category.class);
    }
}
