package br.com.ecommerce.ecommercemain.dtos.sales;

import java.math.BigDecimal;
import java.util.UUID;

public record SalesProductsRequestDTO(Long id, UUID productCode, String name, String description, String category,
                                      BigDecimal price, Integer quantity) {
}
