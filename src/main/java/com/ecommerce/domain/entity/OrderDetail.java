package com.ecommerce.domain.entity;
import com.ecommerce.domain.entity.key.OrderDetailKey;
import com.ecommerce.domain.entity.key.OrderKey;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "order_details", schema = "public")
@IdClass(OrderDetailKey.class)
public class OrderDetail {

    @Id
    @Column(name = "id", updatable = false)
    private Integer id;

    @Id
    @Column(name = "product_id", updatable = false)
    private Integer productId;

    @Id
    @Column(name = "order_id", updatable = false)
    private Integer orderId;

    @Column(name = "total", updatable = false)
    private Float total;

    @Column(name = "count", updatable = false)
    private Integer count;


    @Column(name = "status", updatable = false)
    private String status;

}
