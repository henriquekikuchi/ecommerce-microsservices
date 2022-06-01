package com.github.henriquekikuchi.usersapiwebflux.dto;

public record LoginRequestDto(
        String email,
        String password
) {
}
