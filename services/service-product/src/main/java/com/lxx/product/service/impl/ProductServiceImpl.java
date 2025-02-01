package com.lxx.product.service.impl;
import java.math.BigDecimal;

import com.lxx.product.bean.Product;
import com.lxx.product.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author lxx
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("99.99"));
        product.setProductName("手机" + productId);
        product.setNum(2);
//        try {
//            Thread.sleep(50000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return product;
    }
}
