package boba.microservice1.gatling;

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
public class GatlingProducer {

    private final KafkaTemplate<String, String> template;

    public void send(String payload, String messageId) throws ExecutionException, InterruptedException {
        Message<String> message = MessageBuilder.withPayload(payload + "messageId=" + messageId)
                                                .setHeader(KafkaHeaders.TOPIC, "gatling.responses")
                                                .setHeader("messageId", messageId)
                                                .setHeader(KafkaHeaders.KEY, messageId)
                                                .build();

        template.send(message);

    }

}
