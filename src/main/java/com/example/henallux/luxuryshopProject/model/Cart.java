package com.example.henallux.luxuryshopProject.model;

import com.example.henallux.luxuryshopProject.DecimalFormater;

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
    public HashMap<Integer, CartItem> getItems(){
        return items;
    }

    /**
     * @param applyReductions : True if the reduction is to be applied, false otherwise.
     * @return Returns the total price with (param = true) or without (param = false) the reduction.
     */
    public double getTotalPrice(boolean applyReductions){
        double total = 0;
        for(CartItem cartItem : this.items.values()){
            total += cartItem.getTotalPrice(applyReductions);
        }
        return DecimalFormater.format(total);
    }

    public double getTotalPrice() {
        return getTotalPrice(true);
    }

}
