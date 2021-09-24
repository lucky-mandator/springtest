package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class GreetingHandler {

    private final SayGreeting sayGreeting;

    public GreetingHandler(SayGreeting sayGreeting){
        this.sayGreeting = sayGreeting;
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        Optional<Object> nameObj = request.attribute("name");
        String name = request.pathVariable("name");
        System.out.println(name);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(sayGreeting.sayHello(name)));
    }
    //BodyInserters.fromValue(new Greeting("Hello Spring!"))
}
