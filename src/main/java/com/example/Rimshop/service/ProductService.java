package com.example.Rimshop.service;

import com.example.Rimshop.DTO.ProductDto;
import com.example.Rimshop.entity.Category;
import com.example.Rimshop.entity.Product;
import com.example.Rimshop.repositories.CategoryRepository;
import com.example.Rimshop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@RequiredArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Transactional
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public ProductDto addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        try {
            Long categoryId = categoryRepository.getCategoryIDByName(productDto.getCategoryTitle());
            product.setCategory(categoryRepository.getReferenceById(categoryId));
        } catch (NullPointerException e) {
            product.setCategory(new Category(productDto.getCategoryTitle()));
        }
        productRepository.save(product);
        return new ProductDto(product);
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

    public Page<Product> findPage(int page, int pageSize) {
        return productRepository.findAllBy(PageRequest.of(page, pageSize));
    }
}
