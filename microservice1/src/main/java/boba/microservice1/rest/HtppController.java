package boba.microservice1.rest;

import boba.microservice1.rabbit.RpcRabbitClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/rest")
@RequiredArgsConstructor
@Slf4j
public class HtppController {
    private final RpcRabbitClient rabbitClient;

    @GetMapping("/{size}")
    public String get(@PathVariable int size) {
        log.info("Received request for payload of size {}", size);
        return rabbitClient.send(size);
    }
}
