## pushover-notification-demo

Spring Boot App demonstrating the use of [Pushover](https://pushover.net/) notifications.

**Prerequisites:**

* [Java 17](https://adoptium.net/)
* [Apache Maven](https:http://maven.apache.org/)

#### How to build and run

Provide your Pushover API token and user key in the 
application properties located under 
```bash
./src/main/resources/application.yml
```
```yaml
pushover:
  apiToken: <YOUR PUSHOVER API TOKEN>
  userId: <YOUR PUSHOVER ID>
  priority: NORMAL
  title: Message
  url: URL
  titleForUrl: Title
  sound: magic
```


Type

```bash
mvn package
mvn spring-boot:run
```

to build and run the application on your local environment.

Type 
```bash
curl http://localhost:8080/greeting/NAME
```
to send a simple Pushover notification.

