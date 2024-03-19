package com.picshop.order.controller;

import com.picshop.order.dto.NewOrderDTORequest;
import com.picshop.order.model.Order;
import com.picshop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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
    // Реализовать формирование и сохранение заказа
    // Данные, передаваемые клиентом:
    // - идентификаторы картин
    // - идентификатор пользователя
    // - необходимую доп. информацию определить самостоятельно
    @PostMapping
    public Mono<Order> createOrder(@RequestBody NewOrderDTORequest newOrder){
        System.out.println(newOrder);
        return orderService.createOrder(newOrder);
    }

}
