package com.product.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String description;
    @Column(name = "active_flg")
    private boolean active;
}
