package com.lxx.order.feign.fallback;

import com.lxx.order.feign.ProductFeignClient;
import com.lxx.product.bean.Product;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 * @author lxx
 */
@Component
public class ProductFeignClientFallback implements ProductFeignClient {

    @Override
    public Product getProductById(Long id) {
        System.out.println("兜底回调...");
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal("0"));
        product.setProductName("未知商品");
        product.setNum(0);
        return product;
    }
}
