package com.example.shop.order;

import com.example.shop.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL )
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "point_used")
    private int pointUsed;

    @Column(name = "cash_amount")
    private int cashAmount;

    @Column(name = "status", length = 25)
    private String status;

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public static Order createOrder(Member member, int pointUsed, List<OrderItem> orderItems) {
        Order order = new Order();
        order.member = member;
        order.pointUsed = pointUsed;
        ;

        order.orderDate = LocalDateTime.now();
        order.status = "ORDERED";

        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }

        order.caculateTotalPrice();

        return order;
    }

    private void caculateTotalPrice() {
        int total = 0;
        for (OrderItem orderItem : this.orderItems) {
            total += orderItem.getTotalPrice();
        }
        this.totalPrice = total;
        this.cashAmount = total - this.pointUsed;
    }
}
