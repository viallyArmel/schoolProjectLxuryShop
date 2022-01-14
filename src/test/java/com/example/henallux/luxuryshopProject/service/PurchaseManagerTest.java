package com.example.henallux.luxuryshopProject.service;

import com.example.henallux.luxuryshopProject.dataAccess.repository.OrderRepository;
import com.example.henallux.luxuryshopProject.model.Cart;
import com.example.henallux.luxuryshopProject.model.CartItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class PurchaseManagerTest {

    private static final String EMAIL_2_ORDERS = "pomanil@icloud.com";
    private static final String EMAIL_10_ORDERS = "armelvially418@icloud.com";

    @Mock
    private OrderRepository orderRepository;

    private PurchaseManager purchaseManager;
    private Cart cart;
    private CartItem item;

    @Before
    public void setup(){
        this.purchaseManager = new PurchaseManager(orderRepository);
        cart = new Cart();
        item = new CartItem();
        item.setPrice(100.0);
        cart.addItem(1, item);
    }

    @Test
    public void applyCartReductionKO(){
        item.setQuantity(1);
        purchaseManager.applyCartReduction(cart);
        Assert.assertEquals(0.0, item.getReduction(), 0.01);
    }

    @Test
    public void applyCartReductionOK(){
        item.setQuantity(2);
        purchaseManager.applyCartReduction(cart);
        Assert.assertEquals(0.05, item.getReduction(), 0.001);
    }
    @Test
    public void applyCartReductionOKGreater(){
        item.setQuantity(3);
        purchaseManager.applyCartReduction(cart);
        Assert.assertEquals(0.10, item.getReduction(),  0.001);
    }

    @Test
    public void applyCartReductionReductionCap(){
        item.setQuantity(5);
        purchaseManager.applyCartReduction(cart);
        Assert.assertEquals(0.2, item.getReduction(), 0.001);
    }

    @Test
    public void countOrderEntityByCustomerEmailIn_2() {
        when(orderRepository.countOrderEntityByCustomerEmail(EMAIL_2_ORDERS)).thenReturn(2);
        Assert.assertEquals(.0, purchaseManager.calculateCustomerReduction(EMAIL_2_ORDERS), 0.001);
    }

    @Test
    public void countOrderEntityByCustomerEmailIn_10() {
        when(orderRepository.countOrderEntityByCustomerEmail(EMAIL_10_ORDERS)).thenReturn(10);
        Assert.assertEquals(0.05, purchaseManager.calculateCustomerReduction(EMAIL_10_ORDERS), 0.001);
    }
}