package com.ecommerce.domain.repository;




import com.ecommerce.domain.entity.Order;
import com.ecommerce.domain.entity.key.OrderKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends CrudRepository<Order, OrderKey> {
    List<Order> findAllByTotalGreaterThan(Integer total) throws Exception;

    @Query(value = "SELECT MAX(id) FROM public.orders", nativeQuery = true)
    Integer findMaxValueId();
}
