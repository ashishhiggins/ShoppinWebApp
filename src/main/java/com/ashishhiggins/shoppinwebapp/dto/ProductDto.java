package com.ashishhiggins.shoppinwebapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Valid
@Data
@Schema(name = "Product",
        description = "Schema to hold Product information"
)
public class ProductDto {


    @Positive
    @Schema(
            description = "Price of the product", example = "100.00"
    )
    private double price;
    @PositiveOrZero
    @Schema(
            description = "Number of product ordered", example = "10"
    )
    private int ordered;
    @PositiveOrZero
    @Schema(
            description = "Number of product available", example = "50"
    )
    private int available;
}
