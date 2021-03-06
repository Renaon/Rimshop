package com.example.Rimshop.controller;

import com.example.Rimshop.entity.Product;
import com.example.Rimshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    private Product product;

    @GetMapping("/add")
    public String add(Model model) {
        this.product = new Product();
        model.addAttribute("product", product);
        return "form";

    }

}
