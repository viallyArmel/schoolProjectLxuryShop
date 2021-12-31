package com.example.henallux.luxuryshopProject.model;

import java.util.ArrayList;

public class Category {
    private ArrayList<Product> products;
    private Integer id;
    private String image;

    public Category (){
        products = new ArrayList<>();
    }

    public String getImage() {
        return image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}

