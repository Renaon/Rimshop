package com.example.Rimshop.entity;

import javax.persistence.*;

@Entity
@Table(name = "shop_cart")
public class ShopCart {
    private Long id;
    private Long userId;
    private Long productId;

    public ShopCart() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    @Column(name = "product_id")
    public Long getProductId() {
        return productId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}