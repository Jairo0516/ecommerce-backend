package com.ecommerce.controller;


import com.ecommerce.controller.dto.ProductDTO;
import com.ecommerce.controller.dto.request.ProductRequestDTO;
import com.ecommerce.controller.dto.response.ProductResponseDTO;
import com.ecommerce.controller.dto.response.ProductsResponseDTO;
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
    public ProductsResponseDTO getProducts(){
        try {
            return productService.getProducts();
        }catch (Exception e){
            return ProductsResponseDTO.builder().statusDTO(
                    StatusDTO.builder().code("400").detailMessageError(e.getMessage()).build()
            ).build();
        }
    }

    @CrossOrigin(origins= "*" , allowedHeaders = "*")
    @ApiOperation(value = "Product list.", response = ResponseDTO.class)
    @RequestMapping(value = "/v1/ecommerce/product/{id}", method = RequestMethod.GET)
    public ProductResponseDTO getProduct(
            @PathVariable Integer id
    ){
        try {
            return productService.getProductById(id);
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
            @RequestBody @Validated ProductRequestDTO productRequestDTO
            ){
        try {
            return productService.createProduct(productRequestDTO);
        }catch (Exception e){
            return ResponseDTO.builder().status(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build()).build();
        }
    }


    @CrossOrigin(origins= "*" , allowedHeaders = "*")
    @ApiOperation(value = "Product update.", response = ResponseDTO.class)
    @RequestMapping(value = "/v1/ecommerce/product", method = RequestMethod.PUT)
    public ResponseDTO updateProducts(
            @RequestBody @Validated ProductRequestDTO productRequestDTO
    ){
        try {
            return productService.updateProduct(productRequestDTO);
        }catch (Exception e){
            return ResponseDTO.builder().status(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build()).build();
        }
    }


    @CrossOrigin(origins= "*" , allowedHeaders = "*")
    @ApiOperation(value = "Product update.", response = ResponseDTO.class)
    @RequestMapping(value = "/v1/ecommerce/product", method = RequestMethod.DELETE)
    public ResponseDTO deleteProducts(
            @RequestBody @Validated ProductRequestDTO productRequestDTO
    ){
        try {
            return productService.deleteProduct(productRequestDTO);
        }catch (Exception e){
            return ResponseDTO.builder().status(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build()).build();
        }
    }

}
