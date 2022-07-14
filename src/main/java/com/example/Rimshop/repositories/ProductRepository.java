package com.example.Rimshop.repositories;

import com.example.Rimshop.entity.Category;
import com.example.Rimshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT id FROM Products WHERE title=:title")
    Long findByName(@Param("title") String name);

    @Query("SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tmain.Products\n" +
            "\tINNER JOIN\n" +
            "\tmain.gb_Category\n" +
            "\tON \n" +
            "\t\tmain.Products.category_id = main.gb_Category.id\n" +
            "WHERE\n" +
            "\tmain.gb_Category.name =:name")
    Long categoryByName(@Param("name") String name);


    @Query("SELECT\\n\" +\n" +
            "                        \"\\t*\\n\" +\n" +
            "                        \"FROM\\n\" +\n" +
            "                        \"\\tProducts\\n\" +\n" +
            "                        \"\\tINNER JOIN\\n\" +\n" +
            "                        \"\\tgb_Category\\n\" +\n" +
            "                        \"\\tON \\n\" +\n" +
            "                        \"\\t\\tProducts.category_id = gb_Category.id\\n\" +\n" +
            "                        \"WHERE\\n\" +\n" +
            "                        \"\\tgb_Category.name = :category")
    public List<Product> getProductsByCategory(@Param("category") String name);
}
