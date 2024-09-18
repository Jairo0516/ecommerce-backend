package com.ecommerce.controller;


import com.ecommerce.controller.dto.OrderDTO;
import com.ecommerce.controller.dto.OrderDetailDTO;
import com.ecommerce.controller.dto.response.OrderDetailsResponseDTO;
import com.ecommerce.controller.dto.response.OrdersResponseDTO;
import com.ecommerce.controller.dto.response.ResponseDTO;
import com.ecommerce.controller.dto.response.StatusDTO;
import com.ecommerce.domain.entity.OrderDetail;
import com.ecommerce.domain.service.OrderDetailService;
import com.ecommerce.domain.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api")
@CrossOrigin(origins= "*" , allowedHeaders = "*")
@RestController
@Validated
@Api(value = "Ecommerce - Order Detail", description = "Operations pertaining to Order Details", tags = "OrderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;


    @CrossOrigin(origins= "*" , allowedHeaders = "*")
    @ApiOperation(value = "Order list.", response = ResponseDTO.class)
    @RequestMapping(value = "/v1/ecommerce/order/detail", method = RequestMethod.GET)
    public OrderDetailsResponseDTO getOrderDetails(){
        try {
            return orderDetailService.getOrderDetails();
        }catch (Exception e){
            return OrderDetailsResponseDTO.builder().statusDTO(
                    StatusDTO.builder().code("400").detailMessageError(e.getMessage()).build()
            ).build();
        }
    }


    @CrossOrigin(origins= "*" , allowedHeaders = "*")
    @ApiOperation(value = "Order create.", response = ResponseDTO.class)
    @RequestMapping(value = "/v1/ecommerce/order/detail", method = RequestMethod.POST)
    public ResponseDTO createOrderDetail(
            @RequestBody @Validated List<OrderDetailDTO> orderDetailDTOList
            ){
        try {
            return orderDetailService.createOrderDetail(orderDetailDTOList);
        }catch (Exception e){
            return ResponseDTO.builder().status(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build()).build();
        }
    }



}
