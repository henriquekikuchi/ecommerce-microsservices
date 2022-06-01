package com.github.willyoliv.sales.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class UserResquestDTO {
    @NotNull(message = "The userCode field cannot be empty or null")
    private UUID userCode;

    @NotEmpty(message = "The userName field cannot be empty or null")
    private String fullName;

    @NotEmpty(message = "The role field cannot be empty or null")
    private String role;

    @NotNull(message = "The email field cannot be empty or null")
    private String email;
}
