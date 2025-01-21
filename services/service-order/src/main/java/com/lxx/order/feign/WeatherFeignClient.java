package com.lxx.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lxx
 */
@FeignClient(value = "weather-client", url = "https://aliv18.data.moji.com")
public interface WeatherFeignClient {

    @PostMapping("/whapi/json/alicityweather/limit")
    String getWeather(@RequestHeader("Authorization") String auth,
        @RequestParam("token") String token, @RequestParam("cityId") String cityId);

}
