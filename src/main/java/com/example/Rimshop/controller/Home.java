package com.example.Rimshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Главная");
        return "index";
    }

    @GetMapping("/Главная.html")
    public String getMain(Model model){
        return index(model);
    }

    @GetMapping("/О-нас.html")
    public String about(Model model) {
        model.addAttribute("title", "О нас");
        return "О-нас";
    }

    @GetMapping("/Контакты.html")
    public String contacts(Model model){
        model.addAttribute("title", "Контакты");
        return "Контакты";
    }
}
