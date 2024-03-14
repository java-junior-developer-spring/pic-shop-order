package com.picshop.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/order/api")
public class OrderController {

    @GetMapping("/user/pictures/{userId}")
    public void getPicturesIdsByUserId(@PathVariable int userId){

    }
}
