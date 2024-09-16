package com.ecommerce.domain.entity;
import com.ecommerce.domain.entity.key.ProductKey;
import com.ecommerce.domain.entity.key.UserAppKey;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "products", schema = "public")
@IdClass(ProductKey.class)
public class Product {

    @Id
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "value")
    private Float value;

    @Column(name = "count")
    private Integer count;

}
