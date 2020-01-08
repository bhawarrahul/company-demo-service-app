package com.product.entity;

import com.product.utils.constants.entity.EntityConstants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = EntityConstants.PRODUCT_CATEGORY_TABLE)
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotNull
    private String name;
    private String description;
    @Column(name = EntityConstants.PRODUCT_CATEGORY_ACTIVE_FLAG)
    @NotNull
    private boolean active;
}
