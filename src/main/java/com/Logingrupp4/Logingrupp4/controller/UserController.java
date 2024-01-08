package com.Logingrupp4.Logingrupp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

@Autowired
    private PasswordEncoder BCryptPasswordEncoder;
    
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
    public String adduser(@ModelAttribute User user, Model model) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("passwordMismatch", true);
            return "register";
        }
        else {
        String encryptedPassword = BCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return "redirect:/";
        }
    } 
}
