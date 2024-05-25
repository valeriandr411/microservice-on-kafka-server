package org.example.service;

import org.example.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductionService {
    private static KafkaTemplate<Long, Order> kafkaTemplate ;
    @Autowired
    public ProductionService(KafkaTemplate<Long, Order> template){
        kafkaTemplate = template;
    }
    public static Order cook(Order order) throws InterruptedException {
        System.out.println(String.format("Заказа №%s начал готовиться...", order.getId()));
        Thread.sleep(60_000);//ожидает 10 секунд
        return order;
    }
    public static Order completed(Order order){
        kafkaTemplate.send("completed", order.getId(), order);
        return order;
    }

}
