package com.picshop.order.repository;

import com.picshop.order.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface OrderRepository extends ReactiveMongoRepository<Order, UUID> {

}
