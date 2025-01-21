package com.lxx.product.bean;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author lxx
 */
@Data
public class Product {

    private Long id;
    private BigDecimal price;
    private String productName;
    private Integer num;

}
