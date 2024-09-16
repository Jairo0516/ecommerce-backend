package com.ecommerce.domain.entity;
import com.ecommerce.domain.entity.key.ProductKey;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "orders", schema = "public")
@IdClass(ProductKey.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Float createDate;

}
