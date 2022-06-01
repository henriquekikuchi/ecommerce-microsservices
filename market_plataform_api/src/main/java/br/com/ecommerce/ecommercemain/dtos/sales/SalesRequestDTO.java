package br.com.ecommerce.ecommercemain.dtos.sales;

import java.util.List;

public record SalesRequestDTO(SalesUserRequestDTO user, List<SalesProductsRequestDTO> products) {
}
