package com.lxx.order.service.impl;

import com.lxx.order.bean.Order;
import com.lxx.order.feign.ProductFeignClient;
import com.lxx.product.bean.Product;
import java.math.BigDecimal;

import com.lxx.order.service.OrderService;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lxx
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private ProductFeignClient productFeignClient;

    @Override
    public Order createOrder(Long productId, Long userId) {
//        Product product = getProductFromRemoteWithLoadBalanceAnnotation(productId);
        Product product = productFeignClient.getProductById(productId);
        Order order = new Order();
        order.setId(1L);
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickname("张三");
        order.setAddress("浙江省");
        order.setProductList(Arrays.asList(product));
        return order;
    }

    private Product getProductFromRemote(Long productId) {
        // 1.获取到商品服务所有的IP+Port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        ServiceInstance instance = instances.get(0);
        String url =
            "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;
        log.info("远程请求路径: {}", url);
        // 2.发送请求
        return restTemplate.getForObject(url, Product.class);
    }

    private Product getProductFromRemoteWithLoadBalance(Long productId) {
        // 1.获取到商品服务所有的IP+Port
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        String url = "http://" + choose.getHost() + ":" + choose.getPort() + "/product/" + productId;
        log.info("远程请求路径: {}", url);
        // 2.发送请求
        return restTemplate.getForObject(url, Product.class);
    }

    private Product getProductFromRemoteWithLoadBalanceAnnotation(Long productId) {
        // 1.获取到商品服务所有的IP+Port
        String url = "http://service-product/product/" + productId;
        log.info("远程请求路径: {}", url);
        // 2.发送请求
        return restTemplate.getForObject(url, Product.class);
    }

}
