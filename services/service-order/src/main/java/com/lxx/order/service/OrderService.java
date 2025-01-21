package com.lxx.order.service;

import com.lxx.order.bean.Order;

/**
 * @author lxx
 */
public interface OrderService {

    Order createOrder(Long productId, Long userId);
}
