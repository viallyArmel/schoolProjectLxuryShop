package com.example.henallux.luxuryshopProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/error")
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping(method = RequestMethod.GET)
    public String getErrorPage(Model model){
        model.addAttribute("title", "404-Error");
        return "ajax:404error";
    }


}
