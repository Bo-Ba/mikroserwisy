package boba.microservice1.rest;

import boba.microservice1.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController()
@RequestMapping("/rest")
@RequiredArgsConstructor
@Slf4j
public class HtppController {
    private final KafkaProducer kafkaProducer;

    @GetMapping("/{size}")
    public String get(@PathVariable int size) throws ExecutionException, InterruptedException {
        log.info("Received request: size={}", size);
        return kafkaProducer.getPayload(size);
    }
}
