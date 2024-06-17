package boba.microservice2.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitResponsesProducer {

    private final RabbitTemplate template;
    private static final String EXCHANGE_NAME = "events";
    private static final String ROUTING_KEY = "responses";

    public void send(String payload, String messageId) {
        log.info("Sending message with ID {}", messageId);
        MessageProperties properties = new MessageProperties();
        properties.setMessageId(messageId);

        Message message = new Message(payload.getBytes(), properties);
        message.getMessageProperties().setExpiration(String.valueOf(70000));
        template.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
    }
}
