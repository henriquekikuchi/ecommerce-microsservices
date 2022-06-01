package com.github.willyoliv.sales.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductRequestDTO {

    @NotNull(message = "The productCode field cannot be empty or null")
    private UUID productCode;

    @NotEmpty(message = "The name field cannot be empty or null")
    private String name;

    @NotEmpty(message = "The description field cannot be empty or null")
    private String description;

    @NotEmpty(message = "The category field cannot be empty or null")
    private String category;

    @NotNull(message = "The price field cannot be empty or null")
    @Min(value = 0, message = "Quantity cannot be negative")
    private BigDecimal price;

    @NotNull(message = "The quantity field cannot be empty or null")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;
}
