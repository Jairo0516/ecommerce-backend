package com.ecommerce.domain.service;


import com.ecommerce.controller.dto.ProductDTO;
import com.ecommerce.controller.dto.request.ProductRequestDTO;
import com.ecommerce.controller.dto.response.ProductResponseDTO;
import com.ecommerce.controller.dto.response.ProductsResponseDTO;
import com.ecommerce.controller.dto.response.ResponseDTO;

public interface ProductService {

    ProductsResponseDTO getProducts();

    ProductResponseDTO getProductById(Integer id);

    ResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    ResponseDTO updateProduct(ProductRequestDTO productRequestDTO);
}
