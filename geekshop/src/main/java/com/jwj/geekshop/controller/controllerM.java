package com.jwj.geekshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerM {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

}
