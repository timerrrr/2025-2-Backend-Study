package com.example.shop.order;

import com.example.shop.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_items")
@Getter
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "order_price")
    private int orderPrice;  //주문 당시 가격

    @Column(name = "quantity")
    private int quantity;  //주문 수량

    public static OrderItem createOrderItem(Product product, int orderPrice, int quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.product = product;
        orderItem.orderPrice = orderPrice;
        orderItem.quantity = quantity;

        product.decreaseStock(quantity);

        return orderItem;
    }

    public int getTotalPrice() {
        return this.orderPrice * this.quantity;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
