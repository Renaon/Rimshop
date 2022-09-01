package com.example.Rimshop.controller;

import com.example.Rimshop.utils.Cart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/cart")
public class CartController {
    private final Cart cart;

    @GetMapping("/add")
    public void addToCart(@RequestParam(name = "productID") Long id) { cart.add(id); }

    @GetMapping("/clear")
    public void clearCart() {
        cart.clear();
    }

}
