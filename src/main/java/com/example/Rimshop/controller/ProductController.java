package com.example.Rimshop.controller;

import com.example.Rimshop.DTO.ProductDto;
import com.example.Rimshop.entity.Category;
import com.example.Rimshop.entity.Product;
import com.example.Rimshop.service.CategoryService;
import com.example.Rimshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private Product product;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

//    @PostMapping("/add")
    @RequestMapping(
            value = "/add",
            produces = "application/json",
            method = {RequestMethod.POST, RequestMethod.PUT}
    )
    public String add(@RequestBody ProductDto product) {
        productService.addProduct(product);
        return "success";
    }

    @GetMapping("/drop")
    public String dropProduct(@RequestParam String id){
        productService.dropProduct(Long.valueOf(id));
        return "success";
    }

    @GetMapping("/products")
    public Page<ProductDto> getAllProducts(@RequestParam(name = "p", defaultValue = "1") int page) {
        Page<Product> productsPage = productService.findPage(page - 1, 10);
        Page<ProductDto> dtoPage = new PageImpl<>(productsPage.getContent().stream().map(ProductDto::new).collect(Collectors.toList()), productsPage.getPageable(), productsPage.getTotalElements());
        return dtoPage;
    }

    @GetMapping("/category")
    @ResponseBody
    public List<ProductDto> getProductsByCategory(@RequestParam(name = "name") String name){
        List<Product> productsPage = productService.getProductsByCategory(name);
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : productsPage) {
            productDtos.add(new ProductDto(product));
        }
        return productDtos;
    }

}
