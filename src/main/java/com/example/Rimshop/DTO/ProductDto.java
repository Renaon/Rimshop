package com.example.Rimshop.DTO;

import com.example.Rimshop.entity.Category;
import com.example.Rimshop.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProductDto implements Serializable {
    private Long id;
    private String title;
    private int price;
    private String category;
    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategory().getName();
    }

    public String getCategoryTitle() {
        return category;
    }

    public String getCategory() {
        return category;
    }
}
