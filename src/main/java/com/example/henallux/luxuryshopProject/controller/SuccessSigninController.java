package com.example.henallux.luxuryshopProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/registered")
public class SuccessSigninController {

    @RequestMapping(method = RequestMethod.GET)
    public String successInscription(){
        return "ajax:successSignin";
    }
}
