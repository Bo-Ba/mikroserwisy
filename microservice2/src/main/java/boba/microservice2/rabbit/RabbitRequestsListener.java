package boba.microservice2.rabbit;

import boba.microservice2.PayloadProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitRequestsListener {

    private final PayloadProvider payloadProvider;
    private final RabbitResponsesProducer rabbitResponsesProducer;


    @RabbitListener(queues = "requests")
    public void getPayload(@Payload Integer size, @Header(AmqpHeaders.MESSAGE_ID) String messageId) {
        log.info("Received message with ID: {} and size: {}", messageId, size);
        String payload = payloadProvider.getRandomPayload(size);
        rabbitResponsesProducer.send(payload, messageId);
    }
}
