package com.example.henallux.luxuryshopProject.controller;

import com.example.henallux.luxuryshopProject.Constants;
import com.example.henallux.luxuryshopProject.dataAccess.dao.ProductDAO;
import com.example.henallux.luxuryshopProject.dataAccess.dao.ProductDataAccess;
import com.example.henallux.luxuryshopProject.model.Cart;
import com.example.henallux.luxuryshopProject.model.CartItem;
import com.example.henallux.luxuryshopProject.model.CurrPage;
import com.example.henallux.luxuryshopProject.service.PurchaseManager;
import com.example.henallux.luxuryshopProject.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping(value = "/products")
@SessionAttributes({Constants.CURRENT_PAGE, Constants.CURRENT_CART})
public class ProductController {
    private ProductDataAccess productDataAccess;
    private TranslationService translationService;
    private PurchaseManager purchaseManager;

    @Autowired
    public ProductController(ProductDAO productDAO, TranslationService translationService, PurchaseManager purchaseManager){
        this.productDataAccess = productDAO;
        this.translationService = translationService;
        this.purchaseManager = purchaseManager;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public String shop(Model model, @ModelAttribute(value = Constants.CURRENT_PAGE)CurrPage page, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart, Locale locale){
        model.addAttribute("categId", 0);
        model.addAttribute(Constants.CURRENT_CART, cart);
        model.addAttribute("cartItem", new CartItem());
        page.setPageID(1);
        model.addAttribute("title", "Products");
        model.addAttribute("products", productDataAccess.getProducts());
        String pageName = locale.getLanguage().equals("en") ? "Shop" : "Boutique";
        model.addAttribute("pageName", pageName);
        return "temp:products";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{id}")
    public String getProductByCategId(Model model, @PathVariable("id")int id, @ModelAttribute(value = Constants.CURRENT_PAGE)CurrPage page, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart, Locale locale){
        model.addAttribute(Constants.CURRENT_CART, cart);
        model.addAttribute("cartItem", new CartItem());
        page.setPageID(2);
        model.addAttribute("categId", id);
        model.addAttribute("title", "Category");
        model.addAttribute("pageName", translationService.getCategoryName(id, locale.getLanguage()));
        model.addAttribute("products", productDataAccess.findProductEntitiesByCategory_Id(id));

        return "temp:products";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/single/{productName}/{categoryID}")
    public String getSingleProduct(Model model, @PathVariable("productName")String name, @PathVariable("categoryID")int id,
                                   @ModelAttribute(value = Constants.CURRENT_PAGE)CurrPage page, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart,
                                   Locale locale){
        model.addAttribute("categId", id);
        model.addAttribute(Constants.CURRENT_CART, cart);
        model.addAttribute("cartItem", new CartItem());
        page.setPageID(3);
        model.addAttribute("title", "Single Product");
        model.addAttribute("product", productDataAccess.findProductEntityByName(name));
        model.addAttribute("categoryName", translationService.getCategoryName(id, locale.getLanguage()));
        return "temp:singleProduct";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(Model model, @Valid @ModelAttribute(value = "cartItem")CartItem cartItem, final BindingResult errors, @ModelAttribute(value = Constants.CURRENT_CART)Cart cart,
                            @ModelAttribute(value = Constants.CURRENT_PAGE)CurrPage page, Locale locale){
        if (!errors.hasErrors()){
            if (cart.getItems().containsKey(cartItem.getProductId())){
                Integer oldQuantity = cart.getItems().get(cartItem.getProductId()).getQuantity();
                cart.getItems().get(cartItem.getProductId()).setQuantity(cartItem.getQuantity() + oldQuantity);
            }else{
                cart.addItem(cartItem.getProductId(), cartItem);
            }
        }
        purchaseManager.applyCartReduction(cart);


        int id = cartItem.getCategId();
        String redirectPage = "ajax:404error";

        switch (page.getPageID()){
            case 1:
                model.addAttribute("products", productDataAccess.getProducts());
                redirectPage = "redirect:/products/all";
                break;
            case 2:
                model.addAttribute("pageName", translationService.getCategoryName(id, locale.getLanguage()));
                model.addAttribute("products", productDataAccess.findProductEntitiesByCategory_Id(id));
                redirectPage = "redirect:/products/category/"+ id;
                break;
            case 3:
                model.addAttribute("product", productDataAccess.findProductEntityByName(cartItem.getLabel()));
                model.addAttribute("categoryName", translationService.getCategoryName(id, locale.getLanguage()));
                redirectPage = "redirect:/products/single/"+cartItem.getLabel()+"/"+ id;
                break;
        }
        return redirectPage;

    }

    @ModelAttribute(value = Constants.CURRENT_PAGE)
    public CurrPage page(){
        return new CurrPage();
    }

    @ModelAttribute(value = Constants.CURRENT_CART)
    public Cart getCart(){
        return new Cart();
    }
}
