package com.example.henallux.luxuryshopProject.model;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CartItem {
    private Integer productId;
    private String label;
    private String image;
    private Double price;
    private Double reduction;
    private Boolean saveOrder;

    private Integer quantity;
    private Integer categId;

    public CartItem (){
        setReduction(0d);
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
        this.price = Math.max(price, 0);
    }

    public Double getReduction () {
        return reduction;
    }

    public void setReduction (Double reduction) {
        this.reduction = Math.min(reduction, 1);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = Math.max(quantity, 0);
    }

    public double totalPrice(boolean applyReduction){
        return (price - (applyReduction? price * reduction : 0)) * quantity;
    }

    public double totalPrice() {
        return totalPrice(true);
    }
}
