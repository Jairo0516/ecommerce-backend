package com.ecommerce.domain.service;


import com.ecommerce.controller.dto.ProductDTO;
import com.ecommerce.controller.dto.response.ProductResponseDTO;
import com.ecommerce.controller.dto.response.ResponseDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface ProductService {

    ProductResponseDTO getProducts();

    ResponseDTO createProduct(ProductDTO productDTO);

    ResponseDTO updateProduct(ProductDTO productDTO);
}
