package com.ps;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class TestHandler {

    public Mono<ServerResponse> test(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON)
                .body(Mono.just("test-3"), String.class);
    }
}
