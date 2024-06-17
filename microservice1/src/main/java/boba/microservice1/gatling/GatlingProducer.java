package boba.microservice1.gatling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GatlingProducer {

    private final RabbitTemplate template;
    private static final String EXCHANGE_NAME = "gatling";
    private static final String ROUTING_KEY = "responses";

    public void send(String payload, String messageId) {
        log.info("Sending gatling response with ID {}", messageId);
        MessageProperties properties = new MessageProperties();
        properties.setMessageId(messageId);

        var body = payload + "messageId=" + messageId;
        Message message = new Message(body.getBytes(), properties);
        message.getMessageProperties().setExpiration(String.valueOf(70000));
        template.send(EXCHANGE_NAME, ROUTING_KEY, message);
    }
}
