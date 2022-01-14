package com.example.henallux.luxuryshopProject.dataAccess.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "`order`")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    private Date date;
    @JoinColumn(name = "customer", referencedColumnName = "id")
    @ManyToOne
    private CustomerEntity customer;

    public OrderEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
