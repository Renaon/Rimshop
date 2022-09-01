package com.example.Rimshop.DTO;

import com.example.Rimshop.entity.CartItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CartItemDto implements Serializable {
    private  BigDecimal price;
    private  BigDecimal pricePerProduct;
    private  int quantity;
    private  Long productID;
    private String productTitle;

    public CartItemDto(CartItem cartItem){
        this.price = cartItem.getPrice();
        this.pricePerProduct = cartItem.getPricePerProduct();
        this.quantity = cartItem.getQuantity();
        this.productID = cartItem.getProduct().getId();
        this.productTitle = cartItem.getProduct().getTitle();
    }
}
