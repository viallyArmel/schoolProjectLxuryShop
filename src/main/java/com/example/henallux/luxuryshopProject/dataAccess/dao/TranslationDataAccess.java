package com.example.henallux.luxuryshopProject.dataAccess.dao;

import com.example.henallux.luxuryshopProject.model.Translation;

import java.util.ArrayList;

public interface TranslationDataAccess {
    ArrayList<Translation> getCategoriesTranslatedIn(String code);
    Translation getCategoryNameByIdAndLocale(int id, String locale);
}
