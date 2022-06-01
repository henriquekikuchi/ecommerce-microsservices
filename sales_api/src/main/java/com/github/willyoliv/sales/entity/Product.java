package com.github.willyoliv.sales.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID productCode;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer quantity;

    @ManyToOne()
    @JoinColumn(name = "sale_id")
    @JsonBackReference
    private Sale sale;
}
