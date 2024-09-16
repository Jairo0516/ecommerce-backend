package com.ecommerce.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ecommerce.util.Constants;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusDTO {

    private String code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String detailMessageError;

    public StatusDTO(String message, String code) {
        this.code = code;
        this.message = message;
        this.detailMessageError = null;
    }

    public StatusDTO() {
        this.code = Constants.SUCCESS_CODE;
        this.message = Constants.SUCCESS_MESSAGE;
        this.detailMessageError = null;
    }
}
