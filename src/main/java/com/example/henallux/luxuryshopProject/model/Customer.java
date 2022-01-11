package com.example.henallux.luxuryshopProject.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Customer implements UserDetails {

    private Integer id;

    @NotBlank
    @Pattern(regexp = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){1,29}$")
    private String firstname;
    @NotBlank
    @Pattern(regexp = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){1,29}$")
    private String lastname;
    @NotBlank
    @Pattern(regexp = "^(?=[a-zA-Z0-9._]{4,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")
    private String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{6,}$")
    private String password;

    @NotBlank
    @Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{6,}$")
    private String passwordAgain;

    @NotBlank
    @Email
    @Pattern(regexp = ".+@.+\\..+")
    private String email;

    @NotEmpty
    @Pattern(regexp = "^[0-9]{0,10}$")
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private String date;
    @NotEmpty
    private String gender;

    private String street;
    private String locality;
    @NotEmpty
    private String country;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(0)
    private Integer postalCode;
    private ArrayList<Order> orders;

    private String authorities;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;


    public Customer() {
        setEnabled(true);
        setCredentialsNonExpired(true);
        setAccountNonLocked(true);
        setAccountNonExpired(true);
        orders = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

        if (date != null && !date.equals("")){
            try {
                birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(this.date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
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

    public void setOrder(Order order) {
        orders.add(order);
    }

    public Order getOrder(int i){
        return orders.get(i);
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (authorities != null && !authorities.isEmpty()){
            String[] authoritiesAsArray = authorities.split(",");

            for (String authority : authoritiesAsArray){
                if (authority != null && !authority.isEmpty())
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return grantedAuthorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString(){
        return username + " \n"+ password + " \n"+
                firstname + " \n"+ lastname + " \n"+
                date + " \n"+ gender + " \n"+ country + " \n"+
                email + " \n"+ street + " \n"+ postalCode + " \n"+ locality
                + " \n"+ phoneNumber;
    }
}
