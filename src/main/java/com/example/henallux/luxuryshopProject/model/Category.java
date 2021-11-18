package com.example.henallux.luxuryshopProject.model;

import java.util.ArrayList;

public class Category {
    private Long id;
    private ArrayList<Product> products;

    public Category (){
        super();
        products = new ArrayList<Product>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}

