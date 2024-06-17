package boba.microservice2.kafka;

import boba.microservice2.PayloadProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaListner {

    private final PayloadProvider payloadProvider;

    @KafkaListener(id="server", topics = "requests")
    @SendTo
    public String listen(Integer size) {
        log.info("Received: {}", size);
        return payloadProvider.getRandomPayload(size);
    }
}
