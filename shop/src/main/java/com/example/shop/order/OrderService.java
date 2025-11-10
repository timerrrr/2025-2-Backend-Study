package com.example.shop.order;

import com.example.shop.member.Member;
import com.example.shop.member.MemberRepository;
import com.example.shop.order.dto.OrderCreateRequest;
import com.example.shop.order.dto.OrderItemRequest;
import com.example.shop.product.Product;
import com.example.shop.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Long createOrder(OrderCreateRequest request){

        Member member = memberRepository.findById(request.getMemberId());
        if(member == null){
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }

        List<OrderItem> orderItems = new ArrayList<>();

        for(OrderItemRequest itemRequest : request.getOrderItems()){
            Product product = productRepository.findById(itemRequest.getProductId());
            if(product == null){
                throw new RuntimeException("상품을 찾을 수 없습니다.");
            }

            OrderItem orderItem = OrderItem.createOrderItem(
                    product,
                    product.getPrice(),
                    itemRequest.getQuantity()
            );

            orderItems.add(orderItem);
        }

        Order order = Order.createOrder(
                member,
                request.getPointUSed(),
                orderItems
        );
        orderRepository.save(order);
        return order.getId();
    }

    @Transactional(readOnly = true)
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Order getOrderById(Long id){
        Order order = orderRepository.findById(id);
        if(order == null){
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }
        return order;
    }

    @Transactional
    public void deleteOrder(Long id){
        Order order = orderRepository.findById(id);
        if(order == null){
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }
        orderRepository.deleteById(id);
    }
}
