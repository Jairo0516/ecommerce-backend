package com.ecommerce.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class OrderDetailDTO {

    private Integer id;
    private Integer productId;
    private Integer orderId;
    private Integer count;
    private Float total;
    private String status;

}
