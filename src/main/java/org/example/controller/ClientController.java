package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Order;
import org.example.model.SetStatusRequest;
import org.example.service.ClientService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pizza")
@Component
public class ClientController {
    @PostMapping("/order/add")
    public String addOrder(@RequestBody Order order) throws InterruptedException {
        Order order1 = ClientService.create(order);
        return String.format("Ваш заказ №%s готовится...", order1.getId());
    }
    @GetMapping("/order/status")
    @ResponseBody
    //проверка статуса заказа по id заказа
    public String getOrderStatus(@RequestParam("id") int id) {
       return ClientService.getOrderStatus(id);
    }
    @GetMapping("/orders")
    //проверка статуса заказа по id заказа
    public List<Order> getOrders() {
        return ClientService.getOrders();
    }
    @GetMapping("/order")
    //проверка статуса заказа по id заказа
    public Order getOrderById(@RequestParam String id) {
        return ClientService.getOrders().get(Integer.getInteger(id));
    }

    @PostMapping("/order/status")
    public Order setStatusById(@RequestBody SetStatusRequest body) {
        Order order = ClientService.getOrder(body.getId());
        order.setStatus(body.getStatus());
        return order;
    }
}
