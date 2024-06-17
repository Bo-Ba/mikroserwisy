package boba.microservice2.armeria;


import boba.microservice2.thrift.ThriftPayloadServiceImpl;
import com.linecorp.armeria.server.thrift.THttpService;
import com.linecorp.armeria.spring.ArmeriaServerConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArmeriaThriftConfiguration {


    @Bean
    public ArmeriaServerConfigurator armeriaServerConfigurator(ThriftPayloadServiceImpl thriftPayloadService) {
        var service = THttpService.builder()
                                  .addService(thriftPayloadService)
                                  .build();
        return serverBuilder -> {
            serverBuilder.service("/thrift", service)
                         .build();
        };
    }

}
