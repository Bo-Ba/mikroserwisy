//package boba.microservice2.spring;
//
//import boba.microservice2.thrift.ThriftPayloadService;
//import boba.microservice2.thrift.ThriftPayloadServiceImpl;
//import io.micrometer.observation.Observation;
//import io.micrometer.observation.ObservationRegistry;
//import lombok.RequiredArgsConstructor;
//import org.apache.thrift.TProcessor;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.protocol.TProtocol;
//import org.apache.thrift.server.TServer;
//import org.apache.thrift.server.TThreadPoolServer;
//import org.apache.thrift.transport.TServerSocket;
//import org.apache.thrift.transport.TTransportException;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PreDestroy;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@Configuration
//@RequiredArgsConstructor
//public class ThriftConfig {
//    private final ObservationRegistry observationRegistry;
//
//    private TServer server;
//    private ExecutorService executorService;
//
//    private int port = 1025;
//
//    @Bean
//    public TServer thriftServer(ThriftPayloadServiceImpl thriftPayloadServiceImpl) {
//        try {
//            TProcessor tprocessor = new ThriftPayloadService.Processor<>(thriftPayloadServiceImpl);
////            TProcessor tprocessor = new InstrumentedThriftProcessor<>(new ThriftPayloadService.Processor<>(thriftPayloadServiceImpl), observationRegistry);
//            TServerSocket serverTransport = new TServerSocket(port);
//            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
//            tArgs.processor(tprocessor);
//            tArgs.protocolFactory(new TBinaryProtocol.Factory());
//            tArgs.minWorkerThreads(5);
//            tArgs.maxWorkerThreads(50);
//            server = new TThreadPoolServer(tArgs);
//
//            executorService = Executors.newSingleThreadExecutor();
//            executorService.submit(() -> {
//                System.out.println("Thrift server has started at port " + port);
//                server.serve();
//            });
//
//            return server;
//        } catch (TTransportException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @PreDestroy
//    public void stopServer() {
//        if (server != null && server.isServing()) {
//            server.stop();
//            executorService.shutdown();
//            System.out.println("Thrift server has stopped.");
//        }
//    }
//
//    public static class InstrumentedThriftProcessor<I extends TProcessor> implements TProcessor {
//
//        private final TProcessor delegate;
//        private final ObservationRegistry observationRegistry;
//
//        public InstrumentedThriftProcessor(TProcessor delegate, ObservationRegistry observationRegistry) {
//            this.delegate = delegate;
//            this.observationRegistry = observationRegistry;
//        }
//
//        @Override
//        public void process(TProtocol in, TProtocol out) throws org.apache.thrift.TException {
//            Observation.createNotStarted("thrift.server.process", observationRegistry)
//                       .contextualName("Thrift Server Process")
//                       .observe(() -> {
//                           try {
//                               delegate.process(in, out);
//                           } catch (org.apache.thrift.TException e) {
//                               throw new RuntimeException(e);
//                           }
//                       });
//        }
//    }
//}
//
//
