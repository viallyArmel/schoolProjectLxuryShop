package com.example.henallux.luxuryshopProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = "/contact")
public class ContactController {

    @RequestMapping(method = RequestMethod.GET)
    public String aboutUs(Locale locale){
        return locale.getLanguage().equals("fr") ? "static:contactUsFr" : "static:contactUsEn";
    }
}
