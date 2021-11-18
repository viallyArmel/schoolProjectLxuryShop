package com.example.henallux.luxuryshopProject.service;

import com.example.henallux.luxuryshopProject.model.CodeLanguage;
import com.example.henallux.luxuryshopProject.model.Language;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LanguageService {
    private ArrayList<CodeLanguage> languages;

    public LanguageService (ArrayList<CodeLanguage> languages){
        setLanguages(languages);
    }
    public LanguageService(){
        this(new ArrayList<CodeLanguage>());
        languages.add(new CodeLanguage("en", "anglais"));
        languages.add(new CodeLanguage("fr", "francais"));
    }

    public void setLanguages(ArrayList<CodeLanguage> languages) {
        this.languages = languages;
    }
    public CodeLanguage getLanguage(int i) {
        return languages.get(i);
    }

    public ArrayList<CodeLanguage> getLanguages() {
        return languages;
    }
}
