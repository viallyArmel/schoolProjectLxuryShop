package com.example.henallux.luxuryshopProject.model;

import java.util.ArrayList;

public class Product {
    private Long id;
    private String name, description;
    private Double price;
    private String picture;
    private ArrayList<OrderLine> orderLines;

    public Product (String name, String description, Double price, String picture){
        setName(name);
        setPicture(picture);
        setPrice(price);
        setDescription(description);
        orderLines = new ArrayList<OrderLine>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product (){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

