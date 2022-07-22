package com.example.Rimshop.repositories;

import com.example.Rimshop.entity.ShopCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopCartRepository extends CrudRepository<ShopCart, Long> {
}