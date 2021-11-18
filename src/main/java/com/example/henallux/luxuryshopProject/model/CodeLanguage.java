package com.example.henallux.luxuryshopProject.model;

public class CodeLanguage {
    private String code;
    private String label;

    public CodeLanguage (String code, String label){
        setCode(code);
        setLabel(label);
    }
    public CodeLanguage(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
