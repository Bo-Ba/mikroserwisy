package boba.microservice1.rabbit;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RpcRabbitClient {

    private final RabbitTemplate template;
    private final ObservationRegistry registry;
    private static final String QUEUE_NAME = "rpc";
    private static final String ROUTING_KEY = "rpc";

    public String send(int size) {
        return Observation.createNotStarted("rabbit rpc request", registry)
                          .observe(
                                  () -> {return template.convertSendAndReceive(QUEUE_NAME, ROUTING_KEY, size).toString();}
                          );
    }
}
