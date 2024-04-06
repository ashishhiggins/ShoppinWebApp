package com.ashishhiggins.shoppinwebapp.Controller;

import com.ashishhiggins.shoppinwebapp.dto.CouponDto;
import com.ashishhiggins.shoppinwebapp.service.ICouponService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/apis/coupons", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
@Tag(name = "Coupon Controller", description = "APIs for Coupons, /fetchCoupons which fetches all the coupons available in the system.")
public class CouponController {

    private ICouponService iCouponService;

    @Operation(summary = "Fetch all coupons", description = "Fetch all the coupons available in the system.")

    @ApiResponses({@ApiResponse(responseCode = "200", description = "List of all coupons available in the system.")})

    @GetMapping("/fetchCoupons")
    public ResponseEntity<List<CouponDto>> fetchAllCoupons() {
        List<CouponDto> couponDtos = iCouponService.fetchAllCoupon();
        return ResponseEntity.status(HttpStatus.OK).body(couponDtos);
    }

}
