package com.example.henallux.luxuryshopProject.model;

public class Translation {
    private String label;
    private Category category;
    private Language language;

    public Translation (String label, Category category, Language language){
        setCategory(category);
        setLabel(label);
        setLanguage(language);
    }
    public Translation (){

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}

