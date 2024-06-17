package boba.microservice1.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.ContainerCustomizer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.DirectReplyToMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("rpc");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        // Set the default reply-to address
        rabbitTemplate.setReplyAddress("amq.rabbitmq.reply-to");
        // Enable mandatory flag to ensure messages are routable
        rabbitTemplate.setMandatory(true);
        // Optional: Configure the template to use the direct reply-to container
        rabbitTemplate.setUseDirectReplyToContainer(true);
        rabbitTemplate.setObservationEnabled(true);
        return rabbitTemplate;
    }

    @Bean
    ContainerCustomizer<DirectReplyToMessageListenerContainer> containerCustomizer() {
        return container -> {
            container.setObservationEnabled(true);
            container.setDefaultRequeueRejected(false);
        };
    }
}