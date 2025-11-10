package com.example.shop.order.dto;

import lombok.Getter;


import java.util.List;

@Getter
public class OrderCreateRequest {
    private Long memberId;
    private int pointUSed; // 어떤 상품인지
    private List<OrderItemRequest> orderItems;

    public OrderCreateRequest(Long memberId, int pointUsed, List<OrderItemRequest> orderItems) {
        this.memberId = memberId;
        this.pointUSed = pointUsed;
        this.orderItems = orderItems;
    }

}
