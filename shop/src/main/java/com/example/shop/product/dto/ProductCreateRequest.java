package com.example.shop.product.dto;

import com.example.shop.common.message.ErrorMessage;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProductCreateRequest {

    @NotBlank(message = ErrorMessage.PRODUCT_NAME_NOT_BLANK)
    @Size(min = 1, max = 100, message = ErrorMessage.PRODUCT_NAME_SIZE)
    private String name;

    @NotNull(message = ErrorMessage.PRODUCT_PRICE_NOT_NULL)
    @Min(value = 0, message = ErrorMessage.PRODUCT_PRICE_MIN)
    private int price;

    @NotNull(message = ErrorMessage.PRODUCT_STOCK_NOT_NULL)
    @Min(value = 0, message = ErrorMessage.PRODUCT_STOCK_MIN)
    private int stock;

    public ProductCreateRequest(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
