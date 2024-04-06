package com.ashishhiggins.shoppinwebapp.mapper;

import com.ashishhiggins.shoppinwebapp.dto.CouponDto;
import com.ashishhiggins.shoppinwebapp.entity.Coupon;

public class CouponMapper {

    public static CouponDto mapToCouponDto(Coupon coupon, CouponDto couponDto) {
        couponDto.setCode(coupon.getCode());
        couponDto.setDiscount(coupon.getDiscount());
        return couponDto;
    }
}
