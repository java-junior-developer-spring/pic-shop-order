package com.picshop.order.repository;

import com.picshop.order.model.Order;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface OrderRepository extends ReactiveMongoRepository<Order, UUID> {

    // Flux<Order> findByUserId(int userId);

    // ? указывает на параметр, 0 - индекс парамера
    // fields - поля, по которым будут извлекаться данные
    @Query(value = "{userId :  ?0}", fields = "{picturesIds: 1, orderedAt:  1}")
    Flux<Order> orderWithUserId(int userId);

}



