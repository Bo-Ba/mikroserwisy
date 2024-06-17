package boba.microservice1.gatling;

import boba.microservice1.rabbit.RabbitRequestsProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
@Slf4j
public class GetlingListener {
    private final RabbitRequestsProducer rabbitClient;

    @RabbitListener(queues = "gatling.requests")
    public void get(@Payload String size, @Header(AmqpHeaders.MESSAGE_ID) String messageId) {
        log.info("Received request with size {}", size);
        rabbitClient.send(Integer.parseInt(size), messageId);
    }
}
