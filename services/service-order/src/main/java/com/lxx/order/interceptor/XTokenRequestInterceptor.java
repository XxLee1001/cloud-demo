package com.lxx.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * @author lxx
 */
@Component
public class XTokenRequestInterceptor implements RequestInterceptor {

    /**
     * 请求拦截器
     * @param requestTemplate 请求模板
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("================XTokenRequestInterceptor================");
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }
}
