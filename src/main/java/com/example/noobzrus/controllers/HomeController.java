package com.example.noobzrus.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomeController {

    @GetMapping("index")
    public String showUploadForm(Model model, Principal principal) {
        return "index";
    }
}
