package com.Logingrupp4.Logingrupp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Logingrupp4.Logingrupp4.model.Product;
import com.Logingrupp4.Logingrupp4.repositories.ProductRepository;

@Controller
@RequestMapping ("/details")
public class ProductController {
   
    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public String details(Model model) {
        Product product = productRepository.findById(1).orElse(null);

        model.addAttribute("product", product);
        
        return "details";
    }

}
