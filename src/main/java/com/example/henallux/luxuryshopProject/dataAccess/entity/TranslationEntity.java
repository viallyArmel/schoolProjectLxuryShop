package com.example.henallux.luxuryshopProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "translation")
public class TranslationEntity {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "label")
    private String label;
    @JoinColumn(name = "translation_category_fk", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;
    @JoinColumn(name = "translation_language_fk", referencedColumnName = "code")
    @ManyToOne
    private LanguageEntity language;

    public TranslationEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}
