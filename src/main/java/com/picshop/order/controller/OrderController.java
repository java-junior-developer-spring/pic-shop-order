package com.picshop.order.controller;

import com.picshop.order.model.Order;
import com.picshop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/order/api")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @GetMapping("/user/pictures/{userId}")
    public Flux<Order> getPicturesIdsByUserId(@PathVariable int userId) {
        return orderService.getPicturesIdsByUserId(userId);
    }
}
