package boba.microservice1.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitRequestsProducer {

    private final RabbitTemplate template;
    private static final String EXCHANGE_NAME = "events";
    private static final String ROUTING_KEY = "requests";

    public void send(int size, String messageId) {
        log.info("Sending message with ID {}", messageId);

        template.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, size, message -> {
            message.getMessageProperties().setMessageId(messageId);
            message.getMessageProperties().setContentType(MessageProperties.CONTENT_TYPE_SERIALIZED_OBJECT);
            message.getMessageProperties().setExpiration(String.valueOf(70000));
            return message;
        });
    }
}
