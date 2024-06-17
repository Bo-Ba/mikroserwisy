package boba.microservice1.kafka;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final ReplyingKafkaTemplate<String, Integer, String> template;

    @Observed
    public String getPayload(int size) throws ExecutionException, InterruptedException {

        return template.sendAndReceive(new ProducerRecord<>("requests", Integer.valueOf(size)), Duration.ofSeconds(60))
                       .get()
                       .value();

    }

}
