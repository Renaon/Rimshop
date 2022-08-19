package com.example.Rimshop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Products")
@Table(name = "Products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @Column(name = "logo_path", length = 300)
    private String logo_path;

    public Product() {
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


//    public String getLogo_path() {
//        return logo_path;
//    }

//    public void setLogo_path(String logo_path) {
//        this.logo_path = logo_path;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

}
