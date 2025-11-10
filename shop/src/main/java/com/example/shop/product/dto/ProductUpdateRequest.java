package com.example.shop.product.dto;

import lombok.Getter;

@Getter
public class ProductUpdateRequest {
    private String name;
    private int price;
    private int stock;

    public ProductUpdateRequest(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
