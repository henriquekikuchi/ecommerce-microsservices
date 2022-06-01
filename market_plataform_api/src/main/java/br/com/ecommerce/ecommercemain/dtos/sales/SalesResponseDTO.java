package br.com.ecommerce.ecommercemain.dtos.sales;

import java.math.BigDecimal;
import java.util.List;

public record SalesResponseDTO(Long id, SalesUserResponseDTO user, List<SalesProductsResponseDTO> products, BigDecimal saleValue) {
}
