package com.example.demo;

import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;

@Service
public class SayGreeting {

    public String sayHello(String name) {
        String greeting = "hello "+name;
        return greeting;
    }
}
