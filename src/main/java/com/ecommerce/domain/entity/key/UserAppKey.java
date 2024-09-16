package com.ecommerce.domain.entity.key;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAppKey implements Serializable {

    private Integer applicationCode;
    private Integer documentType;
    private String documentNumber;

}
