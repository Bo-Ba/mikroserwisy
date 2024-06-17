package boba.microservice2.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, String> template;

    public void send(String payload, String messageId) throws ExecutionException, InterruptedException {
        Message<String> message = MessageBuilder.withPayload(payload)
                                                      .setHeader(KafkaHeaders.TOPIC, "events.responses")
                                                      .setHeader("messageId", messageId)
                                                      .build();
        template.send(message);
    }

}
