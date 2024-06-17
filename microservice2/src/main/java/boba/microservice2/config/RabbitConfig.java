package boba.microservice2.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.ContainerCustomizer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue rpcQueue() {
        return new Queue("rpc.requests", true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("rpc");
    }

    @Bean
    public Binding binding(TopicExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue)
                             .to(exchange)
                             .with("rpc");
    }

    @Bean
    ContainerCustomizer<SimpleMessageListenerContainer> containerCustomizer() {
        return container -> {
            container.setObservationEnabled(true);
            container.setDefaultRequeueRejected(false);
        };
    }
}
