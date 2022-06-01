package com.github.henriquekikuchi.usersapiwebflux.dto;

import com.github.henriquekikuchi.usersapiwebflux.entity.RoleEnum;
import com.github.henriquekikuchi.usersapiwebflux.entity.User;

import java.util.UUID;

public record UserResponseDto(
        UUID userCode,
        String email,
        String fullName,
        RoleEnum role
) {

    public static UserResponseDto fromUser(User user) {
        return new UserResponseDto(
                user.getUserCode(),
                user.getEmail(),
                user.getFullName(),
                user.getRole());
    }
}
