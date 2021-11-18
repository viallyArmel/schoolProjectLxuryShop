package com.example.henallux.luxuryshopProject.model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private Long id;
    private Date date;
    private Customer customer;
    private ArrayList<OrderLine> orderLines;

    public Order (Date date, Customer customer){
        setDate(date);
        setCustomer(customer);
        orderLines = new ArrayList<OrderLine>();
    }

    public void setOrderLine(OrderLine orderLine){
        orderLines.add(orderLine);
    }

    public OrderLine getOrderline(int i){
        return orderLines.get(i);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}

