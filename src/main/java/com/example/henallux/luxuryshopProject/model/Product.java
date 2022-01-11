package com.example.henallux.luxuryshopProject.model;

import javax.validation.constraints.*;

import java.util.ArrayList;

public class Product {
    private Integer id;
    private String name;
    private String description;
    @Min(value = 0)
    private Double price;
    private String picture;
    private Boolean outOfStock;
    private Category category;
    private ArrayList<OrderLine> orderLines;

    public Product (){
        orderLines = new ArrayList<>();
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(Boolean inStock) {
        this.outOfStock = inStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

