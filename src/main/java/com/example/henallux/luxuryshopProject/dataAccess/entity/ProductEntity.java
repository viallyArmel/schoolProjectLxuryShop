package com.example.henallux.luxuryshopProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "picture")
    private String picture;
    @Column(name = "out_of_stock")
    private Boolean out_of_stock;

    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;

    public ProductEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Boolean getOut_of_stock() {
        return out_of_stock;
    }

    public void setOut_of_stock(Boolean inStock) {
        this.out_of_stock = inStock;
    }
}
