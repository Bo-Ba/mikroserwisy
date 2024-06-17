package boba.microservice1.rabbit;

import boba.microservice1.gatling.GatlingProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitResponsesListener {

    private final GatlingProducer gatlingProducer;

    @RabbitListener(queues = "responses")
    public void getPayload(String message, @Header(AmqpHeaders.MESSAGE_ID) String messageId) {
        log.info("Received message: {}", messageId);
        gatlingProducer.send(message, messageId);
    }
}
