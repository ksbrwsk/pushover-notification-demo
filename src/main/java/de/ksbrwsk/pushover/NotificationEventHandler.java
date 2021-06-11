package de.ksbrwsk.pushover;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.pushover.client.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class NotificationEventHandler {

    private final PushoverProperties pushoverProperties;

    @EventListener(PushoverEvent.class)
    public void handleNotificationEvent(PushoverEvent pushoverEvent) throws PushoverException {
        log.info("Prepare sending Pushover notification ...");
        Notification notification = pushoverEvent.getNotification();
        PushoverClient pushoverClient = new PushoverRestClient();
        var result = pushoverClient.pushMessage(
                PushoverMessage.builderWithApiToken(pushoverProperties.getApiToken())
                        .setUserId(pushoverProperties.getUserId())
                        .setMessage(notification.message())
                        .setHTML(true)
                        .setPriority(MessagePriority.NORMAL)
                        .setTitle(notification.title())
                        .setUrl(pushoverProperties.getUrl())
                        .setTitleForURL(pushoverProperties.getTitleForURL())
                        .setSound(pushoverProperties.getSound())
                        .build());
        log.info("Pushover notification send with request-ID {}. Status: {}", result.getRequestId(), result.getStatus());
    }
}
