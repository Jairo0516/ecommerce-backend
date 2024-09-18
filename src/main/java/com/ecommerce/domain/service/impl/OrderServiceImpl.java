package com.ecommerce.domain.service.impl;

import com.ecommerce.controller.dto.OrderDTO;
import com.ecommerce.controller.dto.response.*;
import com.ecommerce.domain.builder.ObjectBuilder;
import com.ecommerce.domain.entity.Order;
import com.ecommerce.domain.repository.OrderRepository;
import com.ecommerce.domain.service.OrderService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@CrossOrigin
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private ObjectBuilder objectBuilder;


    @Override
    public OrdersResponseDTO getOrders(){
        OrdersResponseDTO ordersResponseDTO = new OrdersResponseDTO();
        StatusDTO statusDTO = new StatusDTO();
        try {
            List<Order> orders = orderRepository.findAllByTotalGreaterThan(1);
            if(orders != null){
                List<OrderDTO> orderDTOS = objectBuilder.mapAll(orders, OrderDTO.class);
                ordersResponseDTO.setOrderDTOS(orderDTOS);
                statusDTO.setCode("200");
            }else{
                statusDTO.setCode("404");
                statusDTO.setCode("No se encuentran productos");
            }

        }catch (Exception e){
            statusDTO.setCode("404");
            statusDTO.setMessage(e.getMessage());
        }
        ordersResponseDTO.setStatusDTO(statusDTO);
        return ordersResponseDTO;
    }


    @Override
    public ResponseDTO createOrder(OrderDTO orderDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {

            Order order = objectBuilder.map(orderDTO, Order.class);
            order.setId(orderRepository.findMaxValueId() != null ? orderRepository.findMaxValueId() +1 : 1);

            LocalDate localDate = LocalDate.now();
            order.setCreateDate(localDate.toString());
            orderRepository.save(order);
            responseDTO.setStatus(StatusDTO.builder().code("200").build());

        }catch (Exception e){
            responseDTO.setStatus(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build());
        }

        return responseDTO;
    }

}
