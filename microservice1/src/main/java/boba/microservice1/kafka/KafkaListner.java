package boba.microservice1.kafka;

import boba.microservice1.gatling.GatlingProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaListner {

    private final GatlingProducer gatlingProducer;

    @KafkaListener(id="client.responses", topics = "events.responses")
    public void listen(String message, @Header("messageId") String messageId) throws ExecutionException, InterruptedException {
        log.info("Received message with id {}", messageId);
        gatlingProducer.send(message, messageId);
    }
}
