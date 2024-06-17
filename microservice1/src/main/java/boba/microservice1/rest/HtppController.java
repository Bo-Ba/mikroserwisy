package boba.microservice1.rest;

import boba.microservice1.spring.ThriftConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/rest")
@RequiredArgsConstructor
@Slf4j
public class HtppController {

    private final ThriftConfig.InstrumentedThriftClient instrumentedThriftClient;

    @GetMapping("/{size}")
    public String get(@PathVariable("size") int size) throws TException {
        log.info("Requesting payload of size {}", size);
        return instrumentedThriftClient.getPayload(size);
    }
}
