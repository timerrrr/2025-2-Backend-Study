package com.example.shop.order.dto;

import com.example.shop.common.message.ErrorMessage;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;


import java.util.List;

@Getter
public class OrderCreateRequest {

    @NotNull(message = ErrorMessage.MEMBER_ID_NOT_NULL)
    @Min(value = 1, message = ErrorMessage.MEMBER_ID_MIN)
    private Long memberId;

    @Min(value = 0, message = ErrorMessage.POINT_USED_MIN)
    private int pointUSed; // 어떤 상품인지

    @NotNull(message = ErrorMessage.ORDER_ITEMS_NOT_NULL)
    @Size(min = 1, message = ErrorMessage.ORDER_ITEMS_SIZE)
    @Valid
    private List<OrderItemRequest> orderItems;

    public OrderCreateRequest(Long memberId, int pointUsed, List<OrderItemRequest> orderItems) {
        this.memberId = memberId;
        this.pointUSed = pointUsed;
        this.orderItems = orderItems;
    }

}
