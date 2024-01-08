package com.Logingrupp4.Logingrupp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Logingrupp4.Logingrupp4.model.Product;
import com.Logingrupp4.Logingrupp4.repositories.ProductRepository;

@Controller
@RequestMapping ("/details")
public class ProductController {
   
    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public String details(@RequestParam("productId")int productId, Model model) {
        Product product = productRepository.findById(productId).orElse(null);

        model.addAttribute("product", product);
        
        return "details";
    }

}
