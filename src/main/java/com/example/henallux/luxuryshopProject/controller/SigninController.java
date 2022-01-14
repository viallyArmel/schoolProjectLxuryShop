package com.example.henallux.luxuryshopProject.controller;

import com.example.henallux.luxuryshopProject.dataAccess.dao.CustomerDAO;
import com.example.henallux.luxuryshopProject.dataAccess.dao.CustomerDataAccess;
import com.example.henallux.luxuryshopProject.model.Customer;
import com.example.henallux.luxuryshopProject.dataAccess.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/sign")
public class SigninController {

    private CustomerDataAccess customerDataAccess;

    @Autowired
    public SigninController (CustomerDAO customerDAO){
        this.customerDataAccess = customerDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String signin(Model model){
        model.addAttribute("samePassword", true);
        model.addAttribute("user", new Customer());
        model.addAttribute("countries", Utils.countries);
        return "ajax:signin";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getInscription (Model model, @Valid @ModelAttribute(value = "user") Customer customer,
                                  final BindingResult errors){

        if (!errors.hasErrors() && !customerDataAccess.customerAlreadyExists(customer.getUsername(), customer.getEmail()) && customer.getPasswordAgain().equals(customer.getPassword())) {
           customerDataAccess.save(customer);
           return "redirect:/login";
        }
        if (customerDataAccess.customerAlreadyExists(customer.getUsername(), customer.getEmail())){
            model.addAttribute("customerExists", true);
        }
        if (!customer.getPasswordAgain().equals(customer.getPassword()))
            model.addAttribute("samePassword", false);
        else
            model.addAttribute("samePassword", true);

        model.addAttribute("countries", Utils.countries);
        return "ajax:signin";
    }

}
