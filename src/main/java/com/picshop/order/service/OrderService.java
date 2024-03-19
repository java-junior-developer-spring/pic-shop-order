package com.picshop.order.service;

import com.picshop.order.dto.NewOrderDTORequest;
import com.picshop.order.model.Order;
import com.picshop.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    public Mono<Order> createOrder(NewOrderDTORequest newOrder){
        return orderRepository.save(new Order(
                UUID.randomUUID(),
                newOrder.getUserId(),
                LocalDateTime.now(),
                new ArrayList<>(newOrder.getPictures().keySet()),
                newOrder.getPictures().values().stream()
                        .map(BigDecimal::valueOf)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        ));
        // 1. оправить пользователю на почту
        // 2. оправить продавцу на почту
        // 3. убрать картины из показа

    }
}
