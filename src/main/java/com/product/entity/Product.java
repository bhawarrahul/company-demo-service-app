package com.product.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue()
    private Long id;
    private String pid;
    private String name;
    private String description;
    @Column(name = "active_flg")
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
}
