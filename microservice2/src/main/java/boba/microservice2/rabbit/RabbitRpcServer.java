package boba.microservice2.rabbit;

import boba.microservice2.PayloadProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitRpcServer {

    private final PayloadProvider payloadProvider;

    @RabbitListener(queues = "rpc.requests")
    public String getPayload(int size) {
        log.info("Received request for payload of size {}", size);
        return payloadProvider.getRandomPayload(size);
    }
}
