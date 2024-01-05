package com.Logingrupp4.Logingrupp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Logingrupp4.Logingrupp4.model.User;
import com.Logingrupp4.Logingrupp4.repositories.UserRepository;

@Controller
@RequestMapping ("/register")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping()
    public String register() {
        return "register";
    }

    @GetMapping ("/addUser")
    public String adduser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping ("/addUser")
    public String adduser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/";
    }
}
