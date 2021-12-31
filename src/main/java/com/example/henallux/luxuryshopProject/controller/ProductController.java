package com.example.henallux.luxuryshopProject.controller;

import com.example.henallux.luxuryshopProject.dataAccess.dao.CategoryDAO;
import com.example.henallux.luxuryshopProject.dataAccess.dao.CategoryDataAccess;
import com.example.henallux.luxuryshopProject.dataAccess.dao.ProductDAO;
import com.example.henallux.luxuryshopProject.dataAccess.dao.ProductDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    private ProductDataAccess productDataAccess;
    private CategoryDataAccess categoryDataAccess;

    @Autowired
    public ProductController(ProductDAO productDAO, CategoryDAO categoryDAO){
        this.productDataAccess = productDAO;
        this.categoryDataAccess = categoryDAO;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public String shop(Model model){
        model.addAttribute("title", "Products");
        model.addAttribute("products", productDataAccess.getProducts());
        model.addAttribute("pageName", "Shop");
        return "temp:products";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{id}")
    public String getProductByCategId(Model model, @PathVariable("id")int id){

        model.addAttribute("pageName", categoryDataAccess.findCategoryEntityById(id).getImage());
        model.addAttribute("title", "Category");
        model.addAttribute("products", productDataAccess.findProductEntitiesByCategory_Id(id));

        return "temp:products";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/single/{productName}/{categoryID}")
    public String getSingleProduct(Model model, @PathVariable("productName")String name, @PathVariable("categoryID")int category){
        model.addAttribute("title", "Single Product");
        model.addAttribute("product", productDataAccess.findProductEntityByName(name));
        model.addAttribute("categoryName", categoryDataAccess.findCategoryEntityById(category).getImage());
        return "temp:singleProduct";
    }
}
