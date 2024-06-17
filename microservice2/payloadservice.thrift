namespace java boba.microservice2.thrift

struct TraceContext {
    1: string traceId,
    2: string parentSpanId
}

service ThriftPayloadService {

    string getPayload(1:i32 size, 2:TraceContext traceContext),
}

