package com.example.henallux.luxuryshopProject.model;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CartItem {
    private Integer productId;
    private String label;
    private String image;
    private Double price;
    private Boolean saveOrder;

    @NotNull
    @Min(value = 1)
    private Integer quantity;
    private Integer categId;

    public CartItem (){
        setSaveOrder(false);
    }

    public void setSaveOrder(boolean saveOrder) {
        this.saveOrder = saveOrder;
    }

    public Boolean getSaveOrder() {
        return saveOrder;
    }

    public Integer getCategId() {
        return categId;
    }

    public void setCategId(Integer categId) {
        this.categId = categId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double totalPrice(){
        return price * quantity;
    }

}
