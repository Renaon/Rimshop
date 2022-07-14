package com.example.Rimshop.repositories;

import com.example.Rimshop.entity.Category;
import com.example.Rimshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT id FROM Products WHERE title=:title")
    Long findByName(@Param("title") String name);

    @Query("select p from Products p where p.category.name like :name")
    List<Product> getProductsByCategory(@Param("name") String name);


}
