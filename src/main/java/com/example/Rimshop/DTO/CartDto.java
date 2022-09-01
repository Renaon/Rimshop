package com.example.Rimshop.DTO;

import com.example.Rimshop.utils.Cart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CartDto {
    private List<CartItemDto> items;
    private BigDecimal sum;

    public CartDto(Cart cart) {
        this.items = cart.getItems().stream().map(CartItemDto ::new).collect(Collectors.toList());
        this.sum = cart.getSum();
    }
}
