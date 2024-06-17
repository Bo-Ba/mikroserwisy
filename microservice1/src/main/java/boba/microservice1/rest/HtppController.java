package boba.microservice1.rest;

import boba.microservice1.spring.ThriftConfig;
import lombok.RequiredArgsConstructor;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/rest")
@RequiredArgsConstructor
public class HtppController {

    private final ThriftConfig.InstrumentedThriftClient instrumentedThriftClient;

    @GetMapping
    public String get() throws TException {
        return instrumentedThriftClient.getPayload(5);
    }
}
