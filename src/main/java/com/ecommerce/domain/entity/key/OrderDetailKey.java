package com.ecommerce.domain.entity.key;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetailKey implements Serializable {

    private Integer id;
    private Integer productId;
    private Integer orderId;

}
