package de.ksbrwsk.pushover;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PushoverEvent extends ApplicationEvent {
    private final Notification notification;

    public PushoverEvent(Object source, Notification notification) {
        super(source);
        this.notification = notification;
    }
}
