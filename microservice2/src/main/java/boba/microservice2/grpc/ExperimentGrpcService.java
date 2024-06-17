package boba.microservice2.grpc;

import boba.microservice2.ExperimentServiceGrpc;
import boba.microservice2.PayloadProvider;
import boba.microservice2.Request;
import boba.microservice2.Response;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@AllArgsConstructor
@Slf4j
public class ExperimentGrpcService extends ExperimentServiceGrpc.ExperimentServiceImplBase {

    private final PayloadProvider payloadProvider;

    @Override
    public void getResponse(Request request, StreamObserver<Response> responseObserver) {
        log.info("Received request with size: {}", request.getSize());
        int size = request.getSize();
        String payload = payloadProvider.getRandomPayload(size);
        Response response = Response.newBuilder().setPayload(payload).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
