package org.example.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Listeners {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics = "completed", groupId = "app123")
    public void msListener(ConsumerRecord<Long,Order> record) {
        System.out.println("Заказ готов: " + record.value());
        System.out.println("----------------------------------------");
    }

}
