package com.lxx.order.config;

import feign.Logger;
import feign.Logger.Level;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lxx
 */
@Configuration
public class OrderServiceConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @LoadBalanced // 注解式负载均衡
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
