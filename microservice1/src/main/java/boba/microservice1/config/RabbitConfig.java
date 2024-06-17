package boba.microservice1.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.ContainerCustomizer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.QueueBuilder;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue responsesQueue() {
        return QueueBuilder.nonDurable("responses").ttl(70000).build();
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("events");
    }

    @Bean
    public Queue gatlingRequestsQueue() {
        return QueueBuilder.nonDurable("gatling.requests").ttl(70000).build();
    }

    @Bean
    public TopicExchange gatlingExchange() {
        return new TopicExchange("gatling");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setObservationEnabled(true);
        return rabbitTemplate;
    }

    @Bean
    public Binding binding(TopicExchange exchange, Queue responsesQueue) {
        return BindingBuilder.bind(responsesQueue)
                             .to(exchange)
                             .with("responses");
    }

    @Bean
    public Binding gatlingBinding(TopicExchange gatlingExchange, Queue gatlingRequestsQueue) {
        return BindingBuilder.bind(gatlingRequestsQueue)
                             .to(gatlingExchange)
                             .with("request");
    }

    @Bean
    ContainerCustomizer<SimpleMessageListenerContainer> containerCustomizer() {
        return container -> {
            container.setObservationEnabled(true);
            container.setDefaultRequeueRejected(false);
        };
    }
}