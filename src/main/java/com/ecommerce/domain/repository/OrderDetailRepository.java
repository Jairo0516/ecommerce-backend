package com.ecommerce.domain.repository;




import com.ecommerce.domain.entity.Product;
import com.ecommerce.domain.entity.key.ProductKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderDetailRepository extends CrudRepository<Product, ProductKey> {
    List<Product> findAllByCountGreaterThan(Integer count) throws Exception;
}
