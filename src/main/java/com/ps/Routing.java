package com.ps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class Routing {

    @Autowired
    private TestHandler handler;

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction() {
        return route(
                GET("/test").and(accept(APPLICATION_JSON)),
                handler::test);
    }
}
