package br.com.ecommerce.ecommercemain.dtos.sales;

import java.util.UUID;

public record SalesUserRequestDTO(UUID userCode, String fullName, String role, String email) {
}
