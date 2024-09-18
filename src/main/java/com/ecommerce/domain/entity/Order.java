package com.ecommerce.domain.entity;
import com.ecommerce.domain.entity.key.OrderKey;
import com.ecommerce.domain.entity.key.ProductKey;
import jakarta.persistence.*;
import lombok.*;
import org.joda.time.DateTime;

import java.util.Date;


@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "orders", schema = "public")
@IdClass(OrderKey.class)
public class Order {

    @Id
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "address", updatable = false)
    private String address;

    @Column(name = "total", updatable = false)
    private Float total;


    @Column(name = "create_date", updatable = false)
    private String createDate;

}
