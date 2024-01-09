package com.Logingrupp4.Logingrupp4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.Logingrupp4.Logingrupp4.model.Product;
import com.Logingrupp4.Logingrupp4.repositories.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexController {
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public String startPage(Model model) {
        Iterable<Product> productsList = productRepository.findAll();
        model.addAttribute("products", productsList);
        return "index";
    }
}
