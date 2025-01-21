package com.lxx.order.bean;

import com.lxx.product.bean.Product;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

/**
 * @author lxx
 */
@Data
public class Order {

    private Long id;
    private BigDecimal totalAmount;
    private Long userId;
    private String nickname;
    private String address;
    private List<Product> productList;

}
