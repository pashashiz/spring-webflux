package com.ps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ApplicationTest {

    @Configuration
    @ComponentScan
    public static class Config {

        @Autowired
        private Routing routing;

        @Bean
        public WebTestClient client() {
            return WebTestClient
                    .bindToRouterFunction(routing.monoRouterFunction())
                    .build();
        }
    }

    @Autowired
    private WebTestClient client;

    @Test
    public void main() throws Exception {
        client.get().uri("/test")
                .exchange()
                .expectStatus().isOk();
    }

}
