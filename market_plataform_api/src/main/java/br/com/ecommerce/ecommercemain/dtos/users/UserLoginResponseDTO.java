package br.com.ecommerce.ecommercemain.dtos.users;

import java.util.UUID;

public record UserLoginResponseDTO(UUID userCode, String email, String fullName, String role) {
}
