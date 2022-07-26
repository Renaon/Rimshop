package com.example.Rimshop.controller;

import com.example.Rimshop.entity.Product;
import com.example.Rimshop.service.CategoryService;
import com.example.Rimshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private Product product;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/add")
    public String add(Model model) {
        this.product = new Product();
        model.addAttribute("product", product);
        return "add";

    }

    @GetMapping("/catalog")
    public String catalog(Model model){
        model.addAttribute("title", "Каталог");
        model.addAttribute("categories", categoryService.findAll());
        return "Каталог.html";
    }

}
