package de.ksbrwsk.pushover;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "pushover")
@Component
public class PushoverProperties {
    private String apiToken;
    private String userId;
    private String priority;
    private String title;
    private String url;
    private String titleForURL;
    private String sound;
}
