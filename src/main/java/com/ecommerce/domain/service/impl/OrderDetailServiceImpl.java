package com.ecommerce.domain.service.impl;

import com.ecommerce.controller.dto.OrderDTO;
import com.ecommerce.controller.dto.OrderDetailDTO;
import com.ecommerce.controller.dto.response.OrderDetailsResponseDTO;
import com.ecommerce.controller.dto.response.ResponseDTO;
import com.ecommerce.controller.dto.response.StatusDTO;
import com.ecommerce.domain.builder.ObjectBuilder;
import com.ecommerce.domain.entity.Order;
import com.ecommerce.domain.entity.OrderDetail;
import com.ecommerce.domain.repository.OrderDetailRepository;
import com.ecommerce.domain.service.OrderDetailService;
import com.ecommerce.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@Service
@CrossOrigin
public class OrderDetailServiceImpl implements OrderDetailService {


    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    private ObjectBuilder objectBuilder;


    @Override
    public OrderDetailsResponseDTO getOrderDetails(){
        OrderDetailsResponseDTO orderDetailsResponseDTO = new OrderDetailsResponseDTO();
        StatusDTO statusDTO = new StatusDTO();
        try {
            List<OrderDetail> orderDetails = orderDetailRepository.findAll();
            if(orderDetails != null){
                List<OrderDetailDTO> orderDetailDTOS = objectBuilder.mapAll(orderDetails, OrderDetailDTO.class);
                orderDetailsResponseDTO.setOrderDetailDTOS(orderDetailDTOS);
                statusDTO.setCode("200");
            }else{
                statusDTO.setCode("404");
                statusDTO.setCode("No se encuentran detalle de ordenes");
            }

        }catch (Exception e){
            statusDTO.setCode("404");
            statusDTO.setMessage(e.getMessage());
        }
        orderDetailsResponseDTO.setStatusDTO(statusDTO);
        return orderDetailsResponseDTO;
    }


    @Override
    public ResponseDTO createOrderDetail(List<OrderDetailDTO> orderDetailDTOS) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {

            for(OrderDetailDTO orderDetailDTO : orderDetailDTOS ){

                OrderDetail orderDetail = objectBuilder.map(orderDetailDTO, OrderDetail.class);
                orderDetail.setId(orderDetailRepository.findMaxValueId() != null ? orderDetailRepository.findMaxValueId() +1 : 1);

                orderDetailRepository.save(orderDetail);
            }

            responseDTO.setStatus(StatusDTO.builder().code("200").build());

        }catch (Exception e){
            responseDTO.setStatus(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build());
        }

        return responseDTO;
    }

}
