package boba.microservice1.kafka;

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
    private final KafkaTemplate<String, Integer> template;

    public void send(Integer payloadSize, String messageId) throws ExecutionException, InterruptedException {
        Message<Integer> message = MessageBuilder.withPayload(payloadSize)
                                                      .setHeader(KafkaHeaders.TOPIC, "events.requests")
                                                      .setHeader("messageId", messageId)
                                                      .build();
        template.send(message);
    }

}
