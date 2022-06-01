package com.github.willyoliv.sales.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @OneToMany(mappedBy = "sale",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products;

    private BigDecimal saleValue;

    public void setSaleToProduct() {
        if (!products.isEmpty()) {
            for (Product product : products) {
                product.setSale(this);
            }
        }
    }

}
