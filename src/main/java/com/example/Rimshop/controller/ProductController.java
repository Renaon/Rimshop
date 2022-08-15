package com.example.Rimshop.controller;

import com.example.Rimshop.entity.Product;
import com.example.Rimshop.service.CategoryService;
import com.example.Rimshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private Product product;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/add")
    public String add(@RequestBody Product product) {
        productService.addProduct(product);
        return "success";
    }

    @GetMapping("/catalog")
    public List<Product> catalog(){
        return productService.getAllProducts() ;
    }

}
