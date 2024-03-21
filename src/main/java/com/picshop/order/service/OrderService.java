package com.picshop.order.service;

import com.picshop.order.dto.NewOrderDTORequest;
import com.picshop.order.model.Order;
import com.picshop.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private final OrderToCatalogService orderToCatalogService;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderToCatalogService orderToCatalogService) {
        this.orderRepository = orderRepository;
        this.orderToCatalogService = orderToCatalogService;
    }

    public Flux<Order> getPicturesIdsByUserId(int userId) {
        return orderRepository.orderWithUserId(userId);
    }

    public Mono<Order> createOrder(NewOrderDTORequest newOrder) {
        return orderRepository.save(new Order(
                        UUID.randomUUID(),
                        newOrder.getUserId(),
                        LocalDateTime.now(),
                        new ArrayList<>(newOrder.getPictures().keySet()),
                        newOrder.getPictures().values().stream()
                                .map(BigDecimal::valueOf)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(order ->
                        orderToCatalogService.archivePictures(order.getPicturesIds())
                                 .log()
                                 .block(Duration.ofSeconds(5)) // true / false
                );
        // 1. оправить пользователю на почту
        // 2. оправить продавцу на почту
        // 3. убрать картины из показа - запрос в сервис каталога:8081
    }
}

// [] <- CatalogService
//    <- NotService
// -> 123 -> Consumer -> сохранить данные в БД ->
// [c] -> Consumer -> []
//        Consumer
// [] [] [] C01 C04 C03

//  Order
class OrderToKafka {
    private UUID number;
    private BigDecimal price;
}
