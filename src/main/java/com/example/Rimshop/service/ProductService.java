package com.example.Rimshop.service;

import com.example.Rimshop.entity.Category;
import com.example.Rimshop.entity.Product;
import com.example.Rimshop.repositories.CategoryRepository;
import com.example.Rimshop.repositories.ProductRepository;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    private Session session;

    @Transactional
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        if (productRepository.findByName(product.getTitle())==0){
            if (categoryRepository.getCategoryByName(product.getCategory().getName()) == null)
                productRepository.save(product);
            else {
                Long exiistLong = categoryRepository.getCategoryByName(product.getCategory().getName()).getId();
                Category existing = categoryRepository.getReferenceById(exiistLong);
                product.setCategory(existing);
                productRepository.save(product);
            }
        }
    }

    public void dropProduct(Long id){
        Product tmProduct = productRepository.getReferenceById(id);
        Category tmpCategory = new Category("temp");
        tmProduct.setCategory(tmpCategory);
        productRepository.delete(tmProduct);
    }

    public List<Product> getProductsByCategory(String categoryName){
        return productRepository.getProductsByCategory(categoryName);
    }

}
