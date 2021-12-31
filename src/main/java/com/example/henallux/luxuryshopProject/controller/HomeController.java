package com.example.henallux.luxuryshopProject.controller;

import com.example.henallux.luxuryshopProject.dataAccess.dao.CategoryDAO;
import com.example.henallux.luxuryshopProject.dataAccess.dao.CategoryDataAccess;
import com.example.henallux.luxuryshopProject.model.Language;
import com.example.henallux.luxuryshopProject.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    private LanguageService languageService;
    private CategoryDataAccess categoryDataAccess;

    @Autowired
    public HomeController(LanguageService languageService, CategoryDAO categoryDAO){
        this.languageService = languageService;
        this.categoryDataAccess = categoryDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("title", "Home page");
        model.addAttribute("languages", languageService.getLanguages());
        model.addAttribute("categoryNames", categoryDataAccess.getImageNameCategories());

        return "temp:home";
    }

    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public String getShopPage(){
        return "redirect:/shop";
    }

}
