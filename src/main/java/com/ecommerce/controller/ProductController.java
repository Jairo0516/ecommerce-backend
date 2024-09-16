package com.ecommerce.controller;


import com.ecommerce.controller.dto.ProductDTO;
import com.ecommerce.controller.dto.response.ProductResponseDTO;
import com.ecommerce.controller.dto.response.ResponseDTO;
import com.ecommerce.controller.dto.response.StatusDTO;
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
@Api(value = "Ecommerce - Product", description = "Operations pertaining to Product", tags = "Product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @CrossOrigin(origins= "*" , allowedHeaders = "*")
    @ApiOperation(value = "Product list.", response = ResponseDTO.class)
    @RequestMapping(value = "/v1/ecommerce/product", method = RequestMethod.GET)
    public ProductResponseDTO getProducts(){
        try {
            return productService.getProducts();
        }catch (Exception e){
            return ProductResponseDTO.builder().statusDTO(
                    StatusDTO.builder().code("400").detailMessageError(e.getMessage()).build()
            ).build();
        }
    }

    @CrossOrigin(origins= "*" , allowedHeaders = "*")
    @ApiOperation(value = "Product create.", response = ResponseDTO.class)
    @RequestMapping(value = "/v1/ecommerce/product", method = RequestMethod.POST)
    public ResponseDTO createProducts(
            @RequestBody @Validated ProductDTO productDTO
            ){
        try {
            return productService.createProduct(productDTO);
        }catch (Exception e){
            return ResponseDTO.builder().status(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build()).build();
        }
    }


    @CrossOrigin(origins= "*" , allowedHeaders = "*")
    @ApiOperation(value = "Product update.", response = ResponseDTO.class)
    @RequestMapping(value = "/v1/ecommerce/product", method = RequestMethod.PUT)
    public ResponseDTO updateProducts(
            @RequestBody @Validated ProductDTO productDTO
    ){
        try {
            return productService.updateProduct(productDTO);
        }catch (Exception e){
            return ResponseDTO.builder().status(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build()).build();
        }
    }

}
