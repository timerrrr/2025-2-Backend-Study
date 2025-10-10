package com.example.shop.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Long createOrder(OrderCreateRequest request){
        Order order = new Order(
                request.getMemberId(),
                request.getProductId(),
                request.getQuantity()
        );
        orderRepository.save(order);
        return order.getId();
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id){
        Order order = orderRepository.findById(id);
        if(order == null){
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }
        return order;
    }

    public void deleteOrder(Long id){
        Order order = orderRepository.findById(id);
        if(order == null){
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }
        orderRepository.deleteById(id);
    }
}
