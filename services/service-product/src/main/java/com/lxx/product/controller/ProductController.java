package com.lxx.product.controller;

import com.lxx.product.bean.Product;
import com.lxx.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxx
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable(value = "id") Long productId, HttpServletRequest request) {
        String header = request.getHeader("X-Token");
        log.info("hello~, header: " + header);
        return productService.getProductById(productId);
    }

}
