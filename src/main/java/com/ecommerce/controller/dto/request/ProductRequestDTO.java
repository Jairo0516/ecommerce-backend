package com.ecommerce.controller.dto.request;

import com.ecommerce.controller.dto.ProductDTO;
import com.ecommerce.domain.entity.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ProductRequestDTO  extends ProductDTO {

    private String base64;

}
