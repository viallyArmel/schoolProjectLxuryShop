package com.example.henallux.luxuryshopProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Locale;

@Controller
@RequestMapping(value = "/privacy")
public class PrivacyController {

    @RequestMapping(method = RequestMethod.GET)
    public String aboutUs(Locale locale){
        return locale.getLanguage().equals("fr") ? "static:privacyFr" : "static:privacyEn";
    }
}
