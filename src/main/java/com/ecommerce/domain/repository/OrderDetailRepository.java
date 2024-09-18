package com.ecommerce.domain.repository;




import com.ecommerce.domain.entity.OrderDetail;
import com.ecommerce.domain.entity.key.OrderDetailKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailKey> {
    List<OrderDetail> findAll();

    @Query(value = "SELECT MAX(id) FROM public.order_details", nativeQuery = true)
    Integer findMaxValueId();
}
