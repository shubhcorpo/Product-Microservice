package com.shubham.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    @Column(name = "PRODUCT_NAME",nullable = false)
    private String productName;
    @Column(name = "PRICE",nullable = false)
    private long price;
    @Column(name = "QUANTITY",nullable = true)
    private long quantity;

}
