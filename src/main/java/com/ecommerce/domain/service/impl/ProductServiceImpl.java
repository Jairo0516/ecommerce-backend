package com.ecommerce.domain.service.impl;

import com.ecommerce.controller.dto.ProductDTO;
import com.ecommerce.controller.dto.response.ProductResponseDTO;
import com.ecommerce.controller.dto.response.ResponseDTO;
import com.ecommerce.controller.dto.response.StatusDTO;
import com.ecommerce.domain.builder.ObjectBuilder;
import com.ecommerce.domain.entity.Product;
import com.ecommerce.domain.repository.ProductRepository;
import com.ecommerce.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ObjectBuilder objectBuilder;


    @Override
    public ProductResponseDTO getProducts(){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        StatusDTO statusDTO = new StatusDTO();
        try {
            List<Product> products = productRepository.findAllByCountGreaterThan(1);
            if(products != null){
                List<ProductDTO> productDTOS = objectBuilder.mapAll(products, ProductDTO.class);
                productResponseDTO.setProductDTOS(productDTOS);
                statusDTO.setCode("200");
            }else{
                statusDTO.setCode("404");
                statusDTO.setCode("No se encuentran productos");
            }

        }catch (Exception e){
            statusDTO.setCode("404");
            statusDTO.setMessage(e.getMessage());
        }
        productResponseDTO.setStatusDTO(statusDTO);
        return productResponseDTO;
    }


    @Override
    public ResponseDTO createProduct(ProductDTO productDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {

            Product product = objectBuilder.map(productDTO, Product.class);
            productRepository.save(product);
            responseDTO.setStatus(StatusDTO.builder().code("200").build());

        }catch (Exception e){
            responseDTO.setStatus(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build());
        }

        return responseDTO;
    }


    @Override
    public ResponseDTO updateProduct(ProductDTO productDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {

            Product product = objectBuilder.map(productDTO, Product.class);
            productRepository.save(product);
            responseDTO.setStatus(StatusDTO.builder().code("200").build());

        }catch (Exception e){
            responseDTO.setStatus(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build());
        }

        return responseDTO;
    }
}
