package com.ecommerce.controller;


import com.ecommerce.controller.dto.OrderDTO;
import com.ecommerce.controller.dto.request.ProductRequestDTO;
import com.ecommerce.controller.dto.response.*;
import com.ecommerce.domain.service.OrderService;
import com.ecommerce.domain.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@CrossOrigin(origins= "*" , allowedHeaders = "*")
@RestController
@Validated
@Api(value = "Ecommerce - Order", description = "Operations pertaining to Orders", tags = "Order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @CrossOrigin(origins= "*" , allowedHeaders = "*")
    @ApiOperation(value = "Order list.", response = ResponseDTO.class)
    @RequestMapping(value = "/v1/ecommerce/order", method = RequestMethod.GET)
    public OrdersResponseDTO getOrders(){
        try {
            return orderService.getOrders();
        }catch (Exception e){
            return OrdersResponseDTO.builder().statusDTO(
                    StatusDTO.builder().code("400").detailMessageError(e.getMessage()).build()
            ).build();
        }
    }


    @CrossOrigin(origins= "*" , allowedHeaders = "*")
    @ApiOperation(value = "Order create.", response = ResponseDTO.class)
    @RequestMapping(value = "/v1/ecommerce/order", method = RequestMethod.POST)
    public ResponseDTO createOrders(
            @RequestBody @Validated OrderDTO orderDTO
            ){
        try {
            return orderService.createOrder(orderDTO);
        }catch (Exception e){
            return ResponseDTO.builder().status(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build()).build();
        }
    }



}
