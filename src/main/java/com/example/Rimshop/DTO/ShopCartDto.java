package com.example.Rimshop.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShopCartDto implements Serializable {
    private final Long id;
    private final Long userId;
    private final Long productId;
}
