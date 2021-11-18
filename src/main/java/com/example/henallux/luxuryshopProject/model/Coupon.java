package com.example.henallux.luxuryshopProject.model;

public class Coupon {
    private Long id;
    private String label;
    private Double value;
    private Customer customer;

    public Coupon (String label, Double value, Customer customer){
        setLabel(label);
        setValue(value);
        setCustomer(customer);
    }
    public Coupon (){
        super();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}

