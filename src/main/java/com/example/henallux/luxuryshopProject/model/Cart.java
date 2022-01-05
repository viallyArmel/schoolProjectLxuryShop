package com.example.henallux.luxuryshopProject.model;

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

    public HashMap<Integer, CartItem> getItems(){
        return items;
    }
    public double totalPrice(){
        double total = 0;
        for(CartItem cartItem : this.items.values()){
            total += cartItem.totalPrice();
        }
        return total;
    }
    public String getTotalPrice(){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(totalPrice());
    }

}
