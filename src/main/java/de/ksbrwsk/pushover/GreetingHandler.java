package de.ksbrwsk.pushover;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Log4j2
@RequiredArgsConstructor
public class GreetingHandler {

    private final PushoverEventPublisher pushoverEventPublisher;

    Mono<ServerResponse> handleGreetingRequest(ServerRequest serverRequest) {
        log.info("handle request {} - {}", serverRequest.method(), serverRequest.path());
        var name = serverRequest.pathVariable("name");
        var message = String.format("Hello, <b>%s</b>!<br/>Greeting from <a href=\"https://github.com/ksbrwsk/pushover-notification-demo\">pushover-notification-demo</a>", name);
        Notification notification = new Notification("Message", message);
        this.pushoverEventPublisher.newPushoverEvent(notification);
        return ServerResponse
                .ok()
                .bodyValue(message);
    }
}
