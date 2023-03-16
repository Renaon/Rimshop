package com.example.Rimshop.service;

import com.example.Rimshop.DTO.ProductDto;
import com.example.Rimshop.entity.Category;
import com.example.Rimshop.entity.Product;
import com.example.Rimshop.repositories.CategoryRepository;
import com.example.Rimshop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Transactional
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public ProductDto addProduct(ProductDto productDto) {
        Product product = new Product();
        try {
            if(productDto.getTitle()
                    .equals(
                            productRepository.loadReferenceByTitle(productDto.getTitle())
                                    .getTitle())
            ){
                logger.info("Найден дубль");
                return null;
            }
        }catch (NullPointerException e){
            logger.info("Похожих не найдено. Создаем.");
        }
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Category category = categoryRepository.getCategoryByName(productDto.getCategoryTitle());
        product.setCategory(Objects.requireNonNullElseGet(category, () -> new Category(productDto.getCategoryTitle())));
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

    public Page<Product>getPageByCategory(String categoryName, int page, int pageSize){
        return productRepository.getProductsByCategory(categoryName, PageRequest.of(page, pageSize));
    }

    public Page<Product> findPage(int page, int pageSize) {
        return productRepository.findAllBy(PageRequest.of(page, pageSize));
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }
}
