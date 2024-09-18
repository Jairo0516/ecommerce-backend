package com.ecommerce.controller.dto.response;

import com.ecommerce.controller.dto.OrderDTO;
import com.ecommerce.controller.dto.OrderDetailDTO;
import com.ecommerce.domain.entity.OrderDetail;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class OrderDetailsResponseDTO {

    private StatusDTO statusDTO;
    private List<OrderDetailDTO> orderDetailDTOS;

}
