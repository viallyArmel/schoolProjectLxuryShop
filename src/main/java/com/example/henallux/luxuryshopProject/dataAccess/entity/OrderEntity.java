package com.example.henallux.luxuryshopProject.dataAccess.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "date")
    private Date date;
    @JoinColumn(name = "order_customer_fk", referencedColumnName = "id")
    @ManyToOne
    private CustomerEntity customer;

    public OrderEntity(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
