package com.example.henallux.luxuryshopProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class LanguageEntity {

    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "label")
    private String label;

    public LanguageEntity (){}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
