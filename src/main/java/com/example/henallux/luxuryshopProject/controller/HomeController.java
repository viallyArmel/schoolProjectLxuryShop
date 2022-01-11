package com.example.henallux.luxuryshopProject.controller;

import com.example.henallux.luxuryshopProject.dataAccess.dao.CategoryDAO;
import com.example.henallux.luxuryshopProject.dataAccess.dao.CategoryDataAccess;
import com.example.henallux.luxuryshopProject.service.LanguageService;
import com.example.henallux.luxuryshopProject.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    private LanguageService languageService;
    private CategoryDataAccess categoryDataAccess;
    private TranslationService translationService;

    @Autowired
    public HomeController(LanguageService languageService, CategoryDAO categoryDAO, TranslationService translationService){
        this.languageService = languageService;
        this.categoryDataAccess = categoryDAO;
        this.translationService = translationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, Locale locale){
        model.addAttribute("title", "Home page");
        model.addAttribute("languages", languageService.getLanguages());
        model.addAttribute("categories", categoryDataAccess.getImageNameCategories());
        model.addAttribute("categoriesLabels", translationService.getAllCatedoryNamesByLocale(locale.getLanguage()));

        return "temp:home";
    }

    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public String getShopPage(){
        return "redirect:/shop";
    }

}
