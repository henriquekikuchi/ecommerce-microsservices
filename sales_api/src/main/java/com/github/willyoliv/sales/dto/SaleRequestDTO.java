package com.github.willyoliv.sales.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class SaleRequestDTO {
    @NotNull(message = "The user field cannot be null")
    @Valid
    private UserResquestDTO user;

    @NotNull(message = "The products field cannot be null")
    @Valid
    private List<ProductRequestDTO> products;
}
