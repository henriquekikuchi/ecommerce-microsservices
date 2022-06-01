package br.com.ecommerce.ecommercemain.dtos.products;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDTO(Long id,
                         UUID productCode,
                         String name,
                         String description,
                         String category,
                         BigDecimal price,
                         Integer quantity) {
}
