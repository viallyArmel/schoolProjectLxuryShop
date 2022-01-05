package com.example.henallux.luxuryshopProject.dataAccess.dao;

import com.example.henallux.luxuryshopProject.model.OrderLine;

import java.util.ArrayList;

public interface OrderLineDataAccess {
    ArrayList<OrderLine> getOrderLines();
    OrderLine save(OrderLine orderLine);
    void delete(OrderLine orderLine);
}
