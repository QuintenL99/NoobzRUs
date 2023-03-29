package com.example.noobzrus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @GetMapping(value = "about")
    public String About(){
        return "about";
    }
}
