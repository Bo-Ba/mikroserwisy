package boba.microservice1.spring;

import boba.microservice1.thrift.ThriftPayloadService;
import boba.microservice1.thrift.TraceContext;
import com.linecorp.armeria.client.ClientFactory;
import com.linecorp.armeria.client.thrift.ThriftClients;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ThriftConfig {

    private final Tracer tracer;

    @Bean
    public ThriftPayloadService.Iface thriftClient() throws TTransportException {
        ClientFactory clientFactory = ClientFactory
                .builder()
                .preferHttp1(false)
                .useHttp2WithoutAlpn(true)
                .build();;

        return ThriftClients.builder("http://microservice2.default.svc.cluster.local:1025")
                     .path("/thrift")
                     .responseTimeoutMillis(5000)
                            .factory(clientFactory)
                     .build(ThriftPayloadService.Iface.class);
    }

    @Bean
    public InstrumentedThriftClient instrumentedThriftClient(ThriftPayloadService.Iface thriftClient) {
        return new InstrumentedThriftClient(thriftClient, tracer);
    }

    public static class InstrumentedThriftClient implements ThriftPayloadService.Iface {

        private final ThriftPayloadService.Iface delegate;
        private final Tracer tracer;

        public InstrumentedThriftClient(ThriftPayloadService.Iface delegate, Tracer tracer) {
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
