package com.picshop.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
public class OrderToCatalogService {
    private WebClient webClient;

    @Autowired
    public OrderToCatalogService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://127.0.0.1:8081/catalog/api")
                .build();
    }

    public Mono<HttpStatusCode> archivePictures(List<Integer> picturesIds) {
        return webClient.get() // http method
                .uri("/archive/{picturesIds}", picturesIds) // "/user/pictures/" + userId
                .retrieve()
                .toEntity(Void.class)
                .flatMap(objectResponseEntity ->
                        Mono.just(objectResponseEntity.getStatusCode()))
                .timeout(Duration.ofSeconds(5)); // TimeOutException
    }
}
