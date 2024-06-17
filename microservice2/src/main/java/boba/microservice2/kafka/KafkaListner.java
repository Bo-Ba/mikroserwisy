package boba.microservice2.kafka;

import boba.microservice2.PayloadProvider;
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

    private final PayloadProvider payloadProvider;
    private final KafkaProducer kafkaProducer;

    @KafkaListener(id="server.requests", topics = "events.requests")
    public void listen(Integer size, @Header("messageId") String messageId)  throws ExecutionException, InterruptedException {
        log.info("Received: {}", size);
        kafkaProducer.send(payloadProvider.getRandomPayload(size), messageId);
    }
}
