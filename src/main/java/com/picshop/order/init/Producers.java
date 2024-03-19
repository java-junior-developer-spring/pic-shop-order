package com.picshop.order.init;

/*
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Producers {

    public void concatMethods(){
        Mono<Cat> catMono = catMono();
        Flux<Cat> catFlux = catFlux();
        Flux<Owner> ownerFlux = ownerFlux();

        // асинхронный
        Flux.merge(catMono(), catFlux()) // Flux
                .flatMap(cat -> );
        // последовательный
        Flux.concat(catMono(), catFlux()) // Flux
                .flatMap(cat -> );

        Mono.zip(catMono(), ownerMono())
                .flatMap(objects -> {
                    objects.getT1(); // cat
                    objects.getT2(); // owner

                }); // Tuple
        */
/*class Adapter{
            public Mono<Cat> catMono;
            public Mono<Owner> ownerMono;

            public Adapter(Mono<Cat> catMono, Mono<Owner> ownerMono) {
                this.catMono = catMono;
                this.ownerMono = ownerMono;
            }
        }
        new Adapter(catMono(), ownerMono());*//*


        catMono().zipWith(ownerMono())
                .flatMap(objects -> {
                    objects.getT1(); // cat
                    objects.getT2(); // owner
                });
        // owner owner // -> owner
        // new Owner(21, "mike", catsCount), 7
        // new Owner(22, "luna", catsCount), 8
        // new Owner(23, "mary", catsCount) 10

        // new Owner(100, "mary" + "luna", "111111")
        ownerFlux().reduce(new Owner(0, "", 0),
                ((owner, owner2) -> {
            owner.catsCount += owner2.catsCount;
            return owner;
        })); // Mono<Owner>
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

    public Mono<Owner> ownerMono(){
        return Mono.just(
                new Owner(23, "mary", "111111")
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
*/
