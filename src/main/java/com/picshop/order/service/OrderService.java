package com.picshop.order.service;

import com.picshop.order.model.Order;
import com.picshop.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> getPicturesIdsByUserId(int userId){
        return orderRepository.orderWithUserId(userId);
    }
}
