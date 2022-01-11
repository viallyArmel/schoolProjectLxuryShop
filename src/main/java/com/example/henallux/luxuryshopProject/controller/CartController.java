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

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_CART})
public class CartController {
    private Boolean saveCurrCart = false;

    private ProductDataAccess productDataAccess;
    private OrderDataAccess orderDataAccess;
    private OrderLineDataAccess orderLineDataAccess;
    private final PurchaseManager purchaseManager;

    @Autowired
    public CartController(PurchaseManager purchaseManager, ProductDAO productDAO, OrderDAO orderDAO, OrderLineDAO orderLineDAO){
        this.productDataAccess = productDAO;
        this.orderDataAccess = orderDAO;
        this.orderLineDataAccess = orderLineDAO;
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

@RequestMapping(value = "/paymentSuccess", method = RequestMethod.GET)
    public String paymentSuccess(@ModelAttribute(value=Constants.CURRENT_CART) Cart cart){
        setSaveCurrCart(false);
        cart.getItems().clear();

        return "redirect:/home";
    }
    @RequestMapping(value = "/paymentFailed", method = RequestMethod.GET)
    public String paymentFailed(){
        return "redirect:/cart";
    }

    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public String saveOrder(Authentication authentication, Model model, @ModelAttribute(value = "cartItem")CartItem cartItem, @ModelAttribute(value = Constants.CURRENT_CART)Cart cart){

        Customer customer = (Customer) authentication.getPrincipal();
        Date today = new Date();

        Order order = new Order(today, customer);
        order.setId(orderDataAccess.save(order).getId());

        ArrayList<OrderLine> orderLines = new ArrayList<>();
        for (CartItem item : cart.getItems().values()){
            Product product = productDataAccess.findProductEntityByName(item.getLabel());
            orderLines.add(new OrderLine(item.getQuantity(), item.getPrice(), product, order));
        }

        for(OrderLine orderLine : orderLines){
            orderLine = orderLineDataAccess.save(orderLine);
        }

        setSaveCurrCart(true);
        model.addAttribute("cartSaved", getSaveCurrCart());
        return "redirect:/cart";
    }


    @ModelAttribute(Constants.CURRENT_CART)
    public Cart newCart (){
        return new Cart();
    }

    public void setSaveCurrCart(Boolean saveCurrCart) {
        this.saveCurrCart = saveCurrCart;
    }

    public Boolean getSaveCurrCart() {
        return saveCurrCart;
    }
}
