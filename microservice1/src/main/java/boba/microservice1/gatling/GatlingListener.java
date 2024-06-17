package boba.microservice1.gatling;

import boba.microservice1.kafka.KafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
@Slf4j
public class GatlingListener {
    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper;

    @KafkaListener(id = "gatlingRequests", topics = "gatling.requests")
    public void listen(@Payload String message) throws ExecutionException, InterruptedException, JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(message);
        String messageId = jsonNode.get("messageId").asText();
        int size = jsonNode.get("size").asInt();
        log.info("Received message with ID: {} and size: {}", messageId, size);

        kafkaProducer.send(size, messageId);
    }
}
