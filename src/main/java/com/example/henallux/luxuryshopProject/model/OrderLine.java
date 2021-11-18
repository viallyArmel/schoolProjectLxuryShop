package com.example.henallux.luxuryshopProject.model;

public class OrderLine {
    private Integer quantity;
    private Double price;
    private Product product;
    private Order order;

    public OrderLine (Integer quantity, Double price, Product product, Order order){
        setOrder(order);
        setPrice(price);
        setProduct(product);
        setQuantity(quantity);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
