package com.example.henallux.luxuryshopProject.service;

import com.example.henallux.luxuryshopProject.dataAccess.entity.CustomerEntity;
import com.example.henallux.luxuryshopProject.dataAccess.repository.OrderLineRepository;
import com.example.henallux.luxuryshopProject.dataAccess.repository.OrderRepository;
import com.example.henallux.luxuryshopProject.model.Cart;
import com.example.henallux.luxuryshopProject.model.CartItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class PurchaseManagerTest {

    private static final String EMAIL = "pomanil@icloud.com";

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private OrderLineRepository orderLineRepository;
    @Mock
    private Cart cartMocked;

    private PurchaseManager purchaseManager;
    private CustomerEntity customerEntity;
    private Cart cart;
    private CartItem item;

    @BeforeEach
    public void setup(){
        this.purchaseManager = new PurchaseManager(orderLineRepository);
        customerEntity = new CustomerEntity();
        cart = new Cart();
        item = new CartItem();
        cart.addItem(1, item);
    }

    @Test
    @DisplayName("applyCartReductions : totalPrice > 500")
    public void applyCartReductionsLess(){
        item.setPrice(100d);
        purchaseManager.applyCartReduction(cart);
        Assertions.assertEquals(cart.getReduction(), 0);
    }

    @Test
    @DisplayName("applyCartReductions : totalPrice <= 500")
    public void applyCartReductions(){
        item.setPrice(500d);
        purchaseManager.applyCartItemReduction(item);
        Assertions.assertEquals(item.getReduction(), (500 * 0.05), 0.01);
    }
    @Test
    @DisplayName("applyCartItemReductions : totalPrice > 500")
    public void applyCartItemReductionsLess(){
        item.setPrice(100d);
        purchaseManager.applyCartItemReduction(item);
        Assertions.assertEquals(item.getReduction(), 0);
    }

    @Test
    @DisplayName("applyCartItemReductions : totalPrice <= 500")
    public void applyCartItemReductions(){
        item.setPrice(500d);
        purchaseManager.applyCartItemReduction(item);
        Assertions.assertEquals(item.getReduction(), (500 - 500 * 0.05), 0.01);
    }

    // when(orderRepository.countOrderEntityByCustomer(customerEntity)).thenReturn(5);
    // Assertions.assertEquals(0, cart.getReduction());

}