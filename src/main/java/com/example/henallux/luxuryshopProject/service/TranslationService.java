package com.example.henallux.luxuryshopProject.service;

import com.example.henallux.luxuryshopProject.dataAccess.dao.TranslationDAO;
import com.example.henallux.luxuryshopProject.dataAccess.dao.TranslationDataAccess;
import com.example.henallux.luxuryshopProject.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TranslationService {
    private TranslationDataAccess translationDataAccess;

    @Autowired
    public TranslationService(TranslationDAO translationDAO){
        this.translationDataAccess = translationDAO;
    }

    public String getCategoryName(int id, String locale){
        return translationDataAccess.getCategoryNameByIdAndLocale(id, locale).getLabel();
    }
    public ArrayList<String> getAllCatedoryNamesByLocale(String locale){

        ArrayList<Translation> translations = translationDataAccess.getCategoriesTranslatedIn(locale);
        ArrayList<String> names = new ArrayList<>();

        for (Translation item : translations){
            names.add(item.getLabel());
        }
        return names;
    }
}
