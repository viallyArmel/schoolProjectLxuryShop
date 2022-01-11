package com.example.henallux.luxuryshopProject.controller;

import com.example.henallux.luxuryshopProject.Constants;
import com.example.henallux.luxuryshopProject.model.Cart;
import com.example.henallux.luxuryshopProject.model.CartItem;
import com.example.henallux.luxuryshopProject.service.PurchaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Locale;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_CART})
public class CartController {

    private final PurchaseManager purchaseManager;

    @Autowired
    public CartController(PurchaseManager purchaseManager){
        this.purchaseManager = purchaseManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCart(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart, Locale locale){
        model.addAttribute(Constants.CURRENT_CART, cart);
        model.addAttribute("cartItem", new CartItem());
        model.addAttribute("locale", locale);
        purchaseManager.applyCartReduction(cart);
        return "temp:cart";
    }


    @RequestMapping(value = "/addQuantity", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute(value = "cartItem")CartItem cartItem, @ModelAttribute(value = Constants.CURRENT_CART)Cart cart){
        Integer newQuantity = cart.getItems().get(cartItem.getProductId()).getQuantity() + 1;
        cart.getItems().get(cartItem.getProductId()).setQuantity(newQuantity);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/removeQuantity", method = RequestMethod.POST)
    public String removeQuantityToCart(@ModelAttribute(value = "cartItem")CartItem cartItem, @ModelAttribute(value = Constants.CURRENT_CART)Cart cart){
        Integer newQuantity = cart.getItems().get(cartItem.getProductId()).getQuantity() - 1;

        if (newQuantity <= 0){
            cart.getItems().remove(cartItem.getProductId());
        }else {
            cart.getItems().get(cartItem.getProductId()).setQuantity(newQuantity);
        }
        return "redirect:/cart";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeToCart(@ModelAttribute(value = "cartItem")CartItem cartItem, @ModelAttribute(value = Constants.CURRENT_CART)Cart cart){

        cart.getItems().remove(cartItem.getProductId());
        return "redirect:/cart";
    }

    @RequestMapping(value = "/paymentSuccess", method = RequestMethod.POST)
    public String paymentSuccess(){
        return "ajax:paymentSuccess";
    }
    @RequestMapping(value = "/paymentFailed", method = RequestMethod.POST)
    public String paymentFailed(){
        return "ajax:paymentFailed";
    }


    @ModelAttribute(Constants.CURRENT_CART)
    public Cart newCart (){
        return new Cart();
    }
}
