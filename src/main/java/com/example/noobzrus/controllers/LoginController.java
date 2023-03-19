package com.example.noobzrus.controllers;

import com.example.noobzrus.models.User;
import com.example.noobzrus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = {"/register","/land"})
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
}
