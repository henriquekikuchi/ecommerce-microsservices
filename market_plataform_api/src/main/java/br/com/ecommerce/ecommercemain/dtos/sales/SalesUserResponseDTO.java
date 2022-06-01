package br.com.ecommerce.ecommercemain.dtos.sales;

import java.util.UUID;

public record SalesUserResponseDTO(Long id, UUID userCode, String fullName, String role, String email) {
}
