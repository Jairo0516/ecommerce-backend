package com.ecommerce.domain.service.impl;

import com.ecommerce.controller.dto.ProductDTO;
import com.ecommerce.controller.dto.request.ProductRequestDTO;
import com.ecommerce.controller.dto.response.ProductResponseDTO;
import com.ecommerce.controller.dto.response.ProductsResponseDTO;
import com.ecommerce.controller.dto.response.ResponseDTO;
import com.ecommerce.controller.dto.response.StatusDTO;
import com.ecommerce.domain.builder.ObjectBuilder;
import com.ecommerce.domain.entity.Product;
import com.ecommerce.domain.repository.ProductRepository;
import com.ecommerce.domain.service.ProductService;
import com.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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


    @Autowired
    private com.ecommerce.service.S3Service s3Service;

    @Override
    public ProductsResponseDTO getProducts(){
        ProductsResponseDTO productResponseDTO = new ProductsResponseDTO();
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
    public ProductResponseDTO getProductById(Integer id){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        StatusDTO statusDTO = new StatusDTO();
        try {
            Product product = productRepository.findAllById(id);
            if(product != null){
                ProductDTO productDTO = objectBuilder.map(product, ProductDTO.class);
                productResponseDTO.setProductDTO(productDTO);
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
    public ResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            String url;
            if(Utils.isBase64(productRequestDTO.getBase64())){
                url = s3Service.uploadBase64File(productRequestDTO.getBase64());
            }else{
                url = productRequestDTO.getImage();
            }

            Product product = objectBuilder.map(productRequestDTO, Product.class);
            product.setImage(url);
            product.setId(productRepository.findMaxValueId() + 1);
            productRepository.save(product);
            responseDTO.setStatus(StatusDTO.builder().code("200").build());

        }catch (Exception e){
            responseDTO.setStatus(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build());
        }

        return responseDTO;
    }


    @Override
    public ResponseDTO updateProduct(ProductRequestDTO productRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            String url;
            if(Utils.isBase64(productRequestDTO.getBase64())){
                url = s3Service.uploadBase64File(productRequestDTO.getBase64());
            }else{
                url = productRequestDTO.getImage();
            }

            Product product = objectBuilder.map(productRequestDTO, Product.class);
            product.setImage(url);
            productRepository.save(product);
            responseDTO.setStatus(StatusDTO.builder().code("200").build());

        }catch (Exception e){
            responseDTO.setStatus(StatusDTO.builder().code("500").detailMessageError(e.getMessage()).build());
        }

        return responseDTO;
    }
}
