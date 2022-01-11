
package com.example.henallux.luxuryshopProject.service;
import com.example.henallux.luxuryshopProject.dataAccess.repository.OrderRepository;
import com.example.henallux.luxuryshopProject.model.Cart;
import com.example.henallux.luxuryshopProject.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseManager {
    private static final double REDUC_MAX = 0.2;
    private static final double REDUC_PC_TRANCHE = 0.05;
    private static final int QUANTITY_TO_GET_REDUC = 2;

    private final OrderRepository orderRepository;

    @Autowired
    public PurchaseManager(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * If the number of CartItem is equal or greater than QUANTITY_TO_GET_REDUC (= 2), an additionnal REDUC_PC_TRANCHE (= 5%) discount on these items will be granted with every added CartItem up to REDUC_MAX_CARTITEM (= 20%).
     * @param item : An item from the cart represented by a CartItem object.
     */
    private void applyCartItemReduction(CartItem item) {
        double reductionPc = 0;
        if(item.getQuantity() >= QUANTITY_TO_GET_REDUC)
            reductionPc =  (item.getQuantity() - QUANTITY_TO_GET_REDUC + 1) * REDUC_PC_TRANCHE;
        item.setReduction(Math.min(reductionPc, REDUC_MAX));
        System.out.println("reduction to cart item : " + item.getReduction());
    }

    public void applyCartReduction(Cart cart) {
        for(CartItem item : cart.getItems().values()) {
            applyCartItemReduction(item);
        }
    }

    public double calculateCustomerReduction(String email) {
        return (orderRepository.countOrderEntityByCustomerEmail(email) >= 10) ? 0.05 : 0d;
    }
}
