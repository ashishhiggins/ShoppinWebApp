package com.ashishhiggins.shoppinwebapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CouponDto {
    @Schema(
            description = "Coupon code", example = "OFF10"
    )
    private String code;

    @Schema(
            description = "Discount percentage", example = "10"
    )
    private double discount;

}
