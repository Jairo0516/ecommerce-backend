package com.ecommerce.controller.dto.response;

import com.ecommerce.controller.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ProductResponseDTO {

    private StatusDTO statusDTO;
    private ProductDTO productDTO;

}
