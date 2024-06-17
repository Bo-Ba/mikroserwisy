package boba.microservice2.thrift;

import boba.microservice2.PayloadProvider;
import io.opentelemetry.api.trace.*;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ThriftPayloadServiceImpl implements ThriftPayloadService.Iface {

    private final PayloadProvider payloadProvider;
    private final Tracer tracer;


    @Override
    public String getPayload(int size, TraceContext traceContext) throws TException {
        log.info("Received request for payload of size {} and traceContext {}", size, traceContext);

        var spanContext = SpanContext.createFromRemoteParent(
                traceContext.getTraceId(),
                traceContext.getParentSpanId(),
                TraceFlags.getSampled(),
                TraceState.getDefault());

        SpanBuilder spanBuilder = tracer.spanBuilder("thrift server getPayload")
                                        .setParent(Context.current().with(Span.wrap(spanContext)))
                                        .setSpanKind(SpanKind.SERVER);

        Span span = spanBuilder.startSpan();

        try (Scope scope = span.makeCurrent()) {
            return payloadProvider.getRandomPayload(size);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.end();
        }
    }
}
