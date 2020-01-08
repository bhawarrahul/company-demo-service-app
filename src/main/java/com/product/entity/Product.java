package com.product.entity;

import com.product.utils.constants.entity.EntityConstants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String pid;
    private String name;
    private String description;
    @Column(name = EntityConstants.PRODUCT_ACTIVE_FLAG)
    @NotNull
    private boolean active;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.PRODUCT_CATEGORY_ID)
    @NotNull
    private ProductCategory productCategory;
}
