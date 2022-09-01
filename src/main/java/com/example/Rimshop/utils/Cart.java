package com.example.Rimshop.utils;

import com.example.Rimshop.entity.CartItem;
import com.example.Rimshop.service.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@RequiredArgsConstructor
public class Cart {
    private final ProductService productService;
    private List<CartItem> items;
    private BigDecimal sum;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public void add(Long id) {
        for (CartItem cart : items) {
            if (cart.getProduct().getId().equals(id)){
                cart.incrementQuantity();

            }
        }
    }

    public void recalculateCart(){
        sum = BigDecimal.ZERO;
        for (CartItem cart : items) {
            sum = sum.add(cart.getPrice());
        }
    }

    public void clear() {
        items.clear();
        recalculateCart();
    }
}
