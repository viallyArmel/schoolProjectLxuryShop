package com.example.henallux.luxuryshopProject.model;

import com.example.henallux.luxuryshopProject.service.PurchaseManager;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Cart {
    private HashMap<Integer, CartItem> items;

    public Cart(){
        this.items = new HashMap<>();
    }

    public void addItem(Integer key, CartItem cartItem){
        this.items.put(key, cartItem);
    }

    public boolean hasReduction() {
        boolean itemHaveReduction = false;
        for(CartItem item : items.values()){
            if(item.getReduction() > 0)
                itemHaveReduction = true;
        }
        return itemHaveReduction;
    }

    // public void setHasReduction(boolean hasReduction) {
    //     this.hasReduction = hasReduction;
    // }

    public HashMap<Integer, CartItem> getItems(){
        return items;
    }

    /**
     * @param applyReductions : True if the reduction is to be applied, false otherwise.
     * @return Returns the total price with (param = true) or without (param = false) the reduction.
     */
    public double totalPrice(boolean applyReductions){
        double total = 0;
        for(CartItem cartItem : this.items.values()){
            total += cartItem.totalPrice(applyReductions);
        }
        return total;
    }

    public double totalPrice() {
        return totalPrice(true);
    }

    /**
     * @param applyReductions : True if the reduction is to be applied, false otherwise.
     * @return Returns a String representing the total price with (param = true) or without (param = false) the reduction.
     */
    public String getTotalPrice(boolean applyReductions){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(totalPrice(applyReductions));
    }
}
