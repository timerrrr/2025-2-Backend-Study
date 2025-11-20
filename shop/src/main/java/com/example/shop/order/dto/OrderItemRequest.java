package com.example.shop.order.dto;

import com.example.shop.common.message.ErrorMessage;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OrderItemRequest {
    @NotNull(message = ErrorMessage.PRODUCT_ID_NOT_NULL)
    @Min(value = 1, message = ErrorMessage.PRODUCT_ID_MIN)
    private Long productId;

    @NotNull(message = ErrorMessage.QUANTITY_NOT_NULL)
    @Min(value = 1, message = ErrorMessage.QUANTITY_MIN)
    private int quantity;

    public OrderItemRequest(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
