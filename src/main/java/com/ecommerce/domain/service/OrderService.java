package com.ecommerce.domain.service;


import com.ecommerce.controller.dto.OrderDTO;
import com.ecommerce.controller.dto.ProductDTO;
import com.ecommerce.controller.dto.request.ProductRequestDTO;
import com.ecommerce.controller.dto.response.OrdersResponseDTO;
import com.ecommerce.controller.dto.response.ProductResponseDTO;
import com.ecommerce.controller.dto.response.ProductsResponseDTO;
import com.ecommerce.controller.dto.response.ResponseDTO;

public interface OrderService {

    OrdersResponseDTO getOrders();

    ResponseDTO createOrder(OrderDTO orderDTO);
}
