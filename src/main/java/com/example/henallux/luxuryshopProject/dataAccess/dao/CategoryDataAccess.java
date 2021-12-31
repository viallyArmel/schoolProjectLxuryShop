package com.example.henallux.luxuryshopProject.dataAccess.dao;

import com.example.henallux.luxuryshopProject.model.Category;

import java.util.ArrayList;

public interface CategoryDataAccess {
    ArrayList<String> getImageNameCategories();
    Category findCategoryEntityById(int id);
}
