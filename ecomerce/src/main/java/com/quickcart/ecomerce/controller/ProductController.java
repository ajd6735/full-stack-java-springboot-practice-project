package com.quickcart.ecomerce.controller;

import com.quickcart.ecomerce.model.Product;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {
    private final List<Product> productsList = new ArrayList<>(List.of(
            new Product(1, "Espresso", 2.50),
            new Product(2, "Latte", 3.50),
            new Product(3, "Croissant", 2.00),
            new Product(4, "Chocolate Muffin", 2.25),
            new Product(5, "Americano", 2.75)
    ));


    @RequestMapping("/add")  // Maps to the URL http://localhost:8080/products/add
    public String showProductForm(Model productAddFormModel) {
        productAddFormModel.addAttribute("product", new Product());  // Add a new product instance to the model
        return "add-new-product";
    }

    @PostMapping("/addNewProduct")  // Handles the form submission
    public String addProduct(@Valid Product product, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("product", product);
            return "add-new-product";
        }

        productsList.add(product);
        return "redirect:/";  // Redirects back to the main product list view
    }

    @RequestMapping("/list")
    public String getAllProducts(Model productListModel){
        productListModel.addAttribute("products", productsList);
        return "menu";
    }

    @RequestMapping("/")
    public String homeRedirect() {
        return "redirect:/list";
    }

}
