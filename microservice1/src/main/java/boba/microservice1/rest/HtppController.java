package boba.microservice1.rest;

import boba.microservice1.ExperimentServiceGrpc;
import boba.microservice1.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/rest")
@RequiredArgsConstructor
@Slf4j
public class HtppController {

    @GrpcClient("microservice2")
    ExperimentServiceGrpc.ExperimentServiceBlockingStub grpcClient;

    @GetMapping("/{size}")
    public String get(@PathVariable("size") int size) {
        log.info("Requesting payload with size: {}", size);
        return grpcClient
                .getResponse(Request.newBuilder().setSize(size).build())
                .getPayload();
    }
}
