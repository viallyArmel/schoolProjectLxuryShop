
package com.example.henallux.luxuryshopProject.service;
import com.example.henallux.luxuryshopProject.dataAccess.entity.CustomerEntity;
import com.example.henallux.luxuryshopProject.dataAccess.repository.CustomerRepository;
import com.example.henallux.luxuryshopProject.dataAccess.repository.OrderLineRepository;
import com.example.henallux.luxuryshopProject.dataAccess.repository.OrderRepository;
import com.example.henallux.luxuryshopProject.model.Cart;
import com.example.henallux.luxuryshopProject.model.CartItem;
import com.example.henallux.luxuryshopProject.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseManager {
    private static final double REDUC_MAX_CARTITEM = 0.2;
    private static final double REDUC_MAX_CUSTOMER = 0.1;

    private final OrderLineRepository orderLineRepository;

    public PurchaseManager(OrderLineRepository orderLineRepository){
        this.orderLineRepository = orderLineRepository;
    }

    /**
     * Receives the logged-in cursomer's email. If he has ordered for a total of at least 200€, reductions will be applied.
     * For each tranche of 100€, a 1% discount will be granted, up to REDUC_MAX_CUSTOMER (= 10%).
     * @param cart : Current cart.
     * @param email : Email of the customer that may benefit a reduction.
     */
    public void applyCustomerReduction(Cart cart, String email){
        double customerOrderSum = orderLineRepository.sumOrderPriceByCustomerEmail(email);

        double reductionPct = 0;
        int reductionIterator = (int)customerOrderSum - 200;
        while(reductionIterator > 100){
            reductionPct += 0.01;
            reductionIterator -= 100;
        }

        reductionPct = Math.min(reductionPct, REDUC_MAX_CUSTOMER);
        cart.setReduction(cart.getReduction() + reductionPct);
    }

    /**
     * If the total value of the cart exceeds 500€, an additionnal 5% discount will be granted.
     * @param cart : Current cart.
     */
    public void applyCartReduction(Cart cart) {
        if(cart.totalPrice(true) >= 500) {
            cart.setReduction(cart.getReduction() + 0.05);
        }
    }

    /**
     * If the number of CartItem is equal or greater than 2, an additionnal 5% discount on these items will be granted with every added CartItem up to REDUC_MAX_CARTITEM (= 20%).
     * @param item : An item from the cart represented by a CartItem object.
     */
    public void applyCartItemReduction(CartItem item) {
        double reductionPct = 0;
        if(item.getQuantity() >= 2)
            reductionPct =  (item.getQuantity() - 1) * 0.05;
        item.setReduction(Math.min(reductionPct, REDUC_MAX_CARTITEM));
    }
}
