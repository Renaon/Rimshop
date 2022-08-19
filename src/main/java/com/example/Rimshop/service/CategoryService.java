package com.example.Rimshop.service;

import com.example.Rimshop.entity.Category;
import com.example.Rimshop.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category getByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }
}
