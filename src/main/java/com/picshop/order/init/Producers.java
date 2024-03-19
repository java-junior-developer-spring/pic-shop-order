package com.picshop.order.init;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Producers {

    public void concatMethods(){
        Mono<Cat> catMono = catMono();
        Flux<Cat> catFlux = catFlux();
        Flux<Owner> ownerFlux = ownerFlux();


    }

    public Flux<Cat> catFlux(){
        return Flux.just(
                new Cat(1, "tom", "black", 21),
                new Cat(2, "jack", "white", 22),
                new Cat(3, "jessy", "ginger", 21)
        );
    }

    public Mono<Cat> catMono(){
        return Mono.just(
                new Cat(4, "ashly", "black", 23)
        );
    }

    public Flux<Owner> ownerFlux(){
        return Flux.just(
                new Owner(21, "mike", "999999"),
                new Owner(22, "luna", "555555"),
                new Owner(23, "mary", "111111")
        );
    }

    public record Cat(int id, String name, String color, int ownerId) { }
    public record Owner(int id, String name, String phone) { }
}
