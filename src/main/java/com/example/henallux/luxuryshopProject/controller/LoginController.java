package com.example.henallux.luxuryshopProject.controller;

import com.example.henallux.luxuryshopProject.configuration.WebSecurityConfiguration;
import com.example.henallux.luxuryshopProject.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = WebSecurityConfiguration.LOGIN_REQUEST)
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String login (Model model, @RequestParam(required = false) String error){

        if (error != null) {
            model.addAttribute("noCredential", "noCredential");
            model.addAttribute("alertClass", "alert alert-danger");
        }
        model.addAttribute("customer", new Customer());
        return "ajax:login";
    }
}
