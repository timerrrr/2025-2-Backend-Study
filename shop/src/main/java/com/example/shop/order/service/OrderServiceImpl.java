package com.example.shop.order.service;

import com.example.shop.common.exception.NotFoundException;
import com.example.shop.common.message.ErrorMessage;
import com.example.shop.member.Member;
import com.example.shop.member.repository.MemberRepository;
import com.example.shop.order.Order;
import com.example.shop.order.OrderItem;
import com.example.shop.order.dto.OrderCreateRequest;
import com.example.shop.order.dto.OrderItemRequest;
import com.example.shop.order.repository.OrderRepository;
import com.example.shop.product.Product;
import com.example.shop.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Long createOrder(OrderCreateRequest request){

        Member member = memberRepository.findById(request.getMemberId());
        if(member == null){
            throw new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND);
        }

        List<OrderItem> orderItems = new ArrayList<>();

        for(OrderItemRequest itemRequest : request.getOrderItems()){
            Product product = productRepository.findById(itemRequest.getProductId());
            if(product == null){
                throw new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND);
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

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrderById(Long id){
        Order order = orderRepository.findById(id);
        if(order == null){
            throw new NotFoundException(ErrorMessage.ORDER_NOT_FOUND);
        }
        return order;
    }

    @Override
    @Transactional
    public void deleteOrder(Long id){
        Order order = orderRepository.findById(id);
        if(order == null){
            throw new NotFoundException(ErrorMessage.ORDER_NOT_FOUND);
        }
        orderRepository.deleteById(id);
    }
}
