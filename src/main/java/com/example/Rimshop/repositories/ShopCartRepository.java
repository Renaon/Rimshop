package com.example.Rimshop.repositories;

import com.example.Rimshop.entity.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopCartRepository extends CrudRepository<CartItem, Long> {
}