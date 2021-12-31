package com.example.henallux.luxuryshopProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @RequestMapping(method = RequestMethod.GET)
    public String getCart(){

        return "temp:cart";
    }
}
