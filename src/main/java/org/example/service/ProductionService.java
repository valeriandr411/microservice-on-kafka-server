package org.example.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.kafka.KafkaProducerConfig;
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
       // ProductionService.setStatus(order.getId(),"COOKING");
        Thread.sleep(60_000);//ожидает 10 секунд
        return order;
    }
    public static Order completed(Order order){
      //  ProductionService.setStatus(order.getId(),"COMPLETED");
        kafkaTemplate.send("completed", order.getId(), order);
        return order;
    }

/*    public static void setStatus(long id, String status){
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri("http://127.0.0.1:8081")
                .contentType(ContentType.JSON)
                .basePath("/pizza/order/status")
                .body(String.format("{\"id\":%d, \"status\":\"%s\"}", id, status));
        Response response = requestSpecification
                .post()
                .then()
                .statusCode(200)
                .extract().response();
    }*/

}
