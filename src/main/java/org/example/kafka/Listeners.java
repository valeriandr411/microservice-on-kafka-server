package org.example.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.model.Order;
import org.example.service.ProductionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class Listeners {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics = "created", groupId = "app123")
    public void msgListener(ConsumerRecord<Long,Order> record) throws InterruptedException, JsonProcessingException {
        System.out.println("Создан заказ: " + record.value());
        System.out.println("----------------------------------------");
        String order = String.valueOf(record.value());
        Order order2 = objectMapper.readValue(order,Order.class);
        ProductionService.cook(order2);
        ProductionService.completed(order2);
    }
}
