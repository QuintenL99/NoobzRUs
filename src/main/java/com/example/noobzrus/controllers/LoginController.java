package com.example.noobzrus.controllers;


import com.example.noobzrus.models.Userss;
import com.example.noobzrus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class LoginController {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = {"user/register","land"})
    public String register(Model model, Principal principal) {
        if (principal != null) return "redirect:../index";
        model.addAttribute("user", new Userss());
        return "user/register";
    }

    @PostMapping("/user/register")
    public String registerUser(@ModelAttribute("user") Userss user,Principal principal) {
        if (principal != null) return "redirect:../index";
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/user/register";
    }

    @GetMapping("users")
    public String users(Model model) {
        Iterable<Userss> users = userRepository.findAll();
        model.addAttribute("user", users);
        return "users";
    }
    @GetMapping("user/login")
    public String login(Principal principal, Model model) {
        if (principal != null) return "redirect:../index";
        return "user/login";
    }

    @GetMapping("user/logout")
    public String logout(Principal principal, Model model) {
        if (principal == null) return "redirect:../index";
        return "user/logout";
    }
}
