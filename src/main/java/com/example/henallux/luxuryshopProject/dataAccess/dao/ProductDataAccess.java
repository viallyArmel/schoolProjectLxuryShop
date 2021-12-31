package com.example.henallux.luxuryshopProject.dataAccess.dao;
import com.example.henallux.luxuryshopProject.model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<Product> getProducts();
    Product findProductEntityByName(String name);
    ArrayList<Product> findProductEntitiesByCategory_Id(Integer category);
    Integer findCategoryIdByProductName(String name);
}
