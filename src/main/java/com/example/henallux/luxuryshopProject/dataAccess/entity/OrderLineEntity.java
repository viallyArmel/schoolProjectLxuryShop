package com.example.henallux.luxuryshopProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderline")
public class OrderLineEntity {

    @Id
    @Column (name = "id")
    private Integer id;
    @Column (name = "quantity")
    private Integer quantity;
    @Column (name = "price")
    private Double price;
    @JoinColumn(name = "orderLine_order_fk", referencedColumnName = "id")
    @ManyToOne
    private OrderEntity order;
    @JoinColumn(name = "orderLine_product_fk", referencedColumnName = "id")
    @ManyToOne
    private ProductEntity product;

    public OrderLineEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
