package de.ksbrwsk.pushover;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PushoverRouter {

    @Bean
    RouterFunction<ServerResponse> http(GreetingHandler greetingHandler) {
        return route()
                .GET("/greeting/{name}", greetingHandler::handleGreetingRequest)
                .build();
    }
}
