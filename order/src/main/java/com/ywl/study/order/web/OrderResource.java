package com.ywl.study.order.web;

import com.ywl.study.order.dao.OrderRepository;
import com.ywl.study.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by mavlarn on 2018/1/20.
 */
@RestController
@RequestMapping("/api/order")
public class OrderResource {

    @PostConstruct
    public void init() {
        Order order = new Order();
        order.setAmount(100);
        order.setTitle("MyOrder");
        order.setDetail("Bought a imooc course");
        orderRepository.save(order);
    }

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("")
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

}
