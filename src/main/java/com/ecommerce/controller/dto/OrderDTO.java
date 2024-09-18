package com.ecommerce.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.joda.time.DateTime;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class OrderDTO {

    private Integer id;
    private String name;
    private String description;
    private String address;
    private Float total;
    private String createDate;

}
