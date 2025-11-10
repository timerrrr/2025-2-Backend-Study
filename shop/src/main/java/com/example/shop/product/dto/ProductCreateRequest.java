package com.example.shop.product.dto;

import lombok.Getter;

@Getter
public class ProductCreateRequest {

    private String name;
    private int price;
    private int stock;

    public ProductCreateRequest(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
