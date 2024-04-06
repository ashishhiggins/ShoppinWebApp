package com.ashishhiggins.shoppinwebapp.service;

import com.ashishhiggins.shoppinwebapp.dto.CouponDto;

import java.util.List;

public interface ICouponService {

    List<CouponDto> fetchAllCoupon();

    boolean validateCoupon(String couponCode);
}
