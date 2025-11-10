package com.example.shop.order.dto;

import lombok.Getter;

@Getter
public class OrderItemRequest {
    private Long productId;
    private int quantity;

    public OrderItemRequest(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
