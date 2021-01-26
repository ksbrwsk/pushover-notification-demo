package de.ksbrwsk.pushover;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private final String title;
    private final String message;
}
