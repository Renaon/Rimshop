package com.example.Rimshop.repositories;

import com.example.Rimshop.entity.Category;
import com.example.Rimshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Component
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT id FROM Products WHERE title=:title")
    Long findByName(@Param("title") String name);

    @Query("select p from Products p where p.category.name like :name")
    List<Product> getProductsByCategory(@Param("name") String name);

    @Query("select p from Products p where p.category.name like :name")
    Page<Product> getProductsByCategory(@Param("name") String name, Pageable pageable);

    Page<Product> findAllBy(Pageable pageable);
}
