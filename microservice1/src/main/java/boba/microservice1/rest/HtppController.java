package boba.microservice1.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/rest")
@RequiredArgsConstructor
@Slf4j
public class HtppController {
    private final RestTemplate rt;

    @GetMapping("/{size}")
    public String get(@PathVariable String size) {
        log.info("Requesting payload of size {}", size);
        return rt.exchange("http://microservice2.default.svc.cluster.local:1025/rest/" + size, HttpMethod.GET, null, String.class).getBody();
    }
}
