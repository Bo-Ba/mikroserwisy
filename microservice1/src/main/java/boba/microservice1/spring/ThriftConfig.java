package boba.microservice1.spring;

import boba.microservice1.thrift.ThriftPayloadService;
import boba.microservice1.thrift.TraceContext;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ThriftConfig {

    private final Tracer tracer;

    @Bean
    public ThriftPayloadService.Client thriftClient() throws TTransportException {
        TTransport transport = new TSocket("microservice2.default.svc.cluster.local", 1025);
//        TTransport transport = new TSocket("localhost", 9090);
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        return new ThriftPayloadService.Client(protocol);
    }

    @Bean
    public InstrumentedThriftClient instrumentedThriftClient(ThriftPayloadService.Client thriftClient) {
        return new InstrumentedThriftClient(thriftClient, tracer);
    }

    public static class InstrumentedThriftClient extends ThriftPayloadService.Client {

        private final ThriftPayloadService.Client delegate;
        private final Tracer tracer;

        public InstrumentedThriftClient(ThriftPayloadService.Client delegate, Tracer tracer) {
            super(delegate.getOutputProtocol());
            this.delegate = delegate;
            this.tracer = tracer;
        }

        @Override
        public String getPayload(int size, TraceContext trace) throws TException {
            var span = tracer.nextSpan().name("thrift client getPayload");
            try (var ws = tracer.withSpan(span.start())) {
                TraceContext traceContext = new TraceContext(span.context().traceId(), span.context().spanId());

                return delegate.getPayload(size, traceContext);
            } finally {
                span.end();
            }
        }

        public String getPayload(int size) throws TException {
            return getPayload(size, null);
        }
    }
}
