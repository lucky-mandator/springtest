package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.awt.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @RouterOperations({ @RouterOperation(path = "/hello/{name}", beanClass = GreetingHandler.class, beanMethod = "hello") })
    //@ApiImplicitParam(name = "worksiteId", value = "worksite id", required = true, dataType = "UUID", paramType = "path")
    @Parameter(name ="name", required = true, schema = @Schema(description = "var 1",type = "string", allowableValues = {"1", "2"}))
    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler){
        return RouterFunctions.route(GET("/hello/{name}").and(accept(MediaType.APPLICATION_JSON)),
                greetingHandler::hello);
    }
}
