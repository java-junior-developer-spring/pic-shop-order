package com.picshop.order.init;

import com.picshop.order.model.Order;
import com.picshop.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Flow;

@Component
public class InitialData {
    private OrderRepository orderRepository;

    @Autowired
    public InitialData(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Bean
    public void initOrder() {
        orderRepository.saveAll(
                        List.of(
                                new Order(UUID.randomUUID(), 1, LocalDateTime.now().minusDays(23), List.of(2, 3)),
                                new Order(UUID.randomUUID(), 2, LocalDateTime.now().minusMonths(7), List.of(1, 4)),
                                new Order(UUID.randomUUID(), 1, LocalDateTime.now().minusYears(1), List.of(5))
                        )
                )
                .subscribeOn(Schedulers.parallel())
                .subscribe();
    }
}
