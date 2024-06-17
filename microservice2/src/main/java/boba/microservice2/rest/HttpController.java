package boba.microservice2.rest;

import boba.microservice2.PayloadProvider;
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
public class HttpController {
    private final PayloadProvider payloadProvider;

    @GetMapping("/{size}")
    public String get(@PathVariable Integer size) {
        log.info("Received request for payload of size {}", size);
        return payloadProvider.getRandomPayload(size);
    }
}
