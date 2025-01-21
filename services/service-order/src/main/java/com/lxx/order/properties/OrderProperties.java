package com.lxx.order.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lxx
 */
@Data
@Component
@ConfigurationProperties(prefix = "order")
public class OrderProperties {

    private String timeout;

    /**
     * -写法映射为驼峰
     */
    private String autoConfirm;

    private String dbUrl;

}
