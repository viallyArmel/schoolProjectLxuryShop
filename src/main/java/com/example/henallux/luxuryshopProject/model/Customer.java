package com.example.henallux.luxuryshopProject.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private Long id;

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String firstName, lastName;
    @NotBlank
    @Email
    private String email;
    private String phoneNumber;
    private Date birthdate;
    private Character gender;
    private String street, locality, country;
    private Integer postalCode;
    private ArrayList<Coupon> coupons;
    private ArrayList<Order> orders;


    public Customer(String username, String password, String firstName, String lastName, String email,
                    String phoneNumber, Date birthdate, Character gender, String street, String locality, Integer postalCode, String country) {
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setBirthdate(birthdate);
        setGender(gender);
        setStreet(street);
        setLocality(locality);
        setPostalCode(postalCode);
        setCountry(country);
        coupons = new ArrayList<Coupon>();
        coupons.add(new Coupon("Coupon de bienvenue", 1., this));
        orders = new ArrayList<Order>();
    }

    public Customer() {
        super();
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
    }

    public void setOrder(Order order) {
        orders.add(order);
    }

    public Order getOrder(int i){
        return orders.get(i);
    }

    public void setCoupon(Coupon coupon){
        coupons.add(coupon);
    }

    public Coupon getCoupon(int i) {
        return coupons.get(i);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
