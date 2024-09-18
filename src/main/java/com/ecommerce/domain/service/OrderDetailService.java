package com.ecommerce.domain.service;


import com.ecommerce.controller.dto.OrderDTO;
import com.ecommerce.controller.dto.OrderDetailDTO;
import com.ecommerce.controller.dto.response.OrderDetailsResponseDTO;
import com.ecommerce.controller.dto.response.OrdersResponseDTO;
import com.ecommerce.controller.dto.response.ResponseDTO;
import com.ecommerce.domain.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    OrderDetailsResponseDTO getOrderDetails();

    ResponseDTO createOrderDetail(List<OrderDetailDTO> orderDetailDTOList);
}
