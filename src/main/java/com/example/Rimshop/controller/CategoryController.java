package com.example.Rimshop.controller;

import com.example.Rimshop.entity.Category;
import com.example.Rimshop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<String> gaCategoryList(){
        List<Category> categories = categoryService.findAll();
        List<String> names = new ArrayList<>();
        for (Category category : categories) {
            names.add(category.getName());
        }
        return names;
    }
}
