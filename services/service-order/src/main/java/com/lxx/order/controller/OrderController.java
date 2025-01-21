package com.lxx.order.controller;

import com.lxx.order.bean.Order;
import com.lxx.order.properties.OrderProperties;
import com.lxx.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxx
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderProperties orderProperties;


    @GetMapping("/config")
    public String config() {
        return "order.timeout=" + orderProperties.getTimeout()
            + "; order.auto-confirm=" + orderProperties.getAutoConfirm()
            + "; order.dbURL=" + orderProperties.getDbUrl();
    }

    @GetMapping("/create")
    public Order createOrder(@RequestParam("productId") Long productId,
        @RequestParam("userId") Long userId) {
        return orderService.createOrder(productId, userId);
    }

}
