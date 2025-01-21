package com.lxx.order;

import com.lxx.order.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lxx
 */
@SpringBootTest
public class WeatherTest {

    @Autowired
    WeatherFeignClient weatherFeignClient;

    @Test
    void testWeather() {
        String weather = weatherFeignClient.getWeather("APPCODE 83359fd73fe94948385f570e3c139105",
            "27200005b3475f8b0e26428f9bfb13e9",
            "2");
        System.out.println(weather);
    }
}
