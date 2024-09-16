package com.ecommerce.domain.repository;




import com.ecommerce.domain.entity.Product;
import com.ecommerce.domain.entity.key.ProductKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, ProductKey> {
    List<Product> findAllByCountGreaterThan(Integer count) throws Exception;

    Product findAllById(Integer id) throws Exception;

    @Query(value = "SELECT MAX(id) FROM public.products", nativeQuery = true)
    Integer findMaxValueId();
}
