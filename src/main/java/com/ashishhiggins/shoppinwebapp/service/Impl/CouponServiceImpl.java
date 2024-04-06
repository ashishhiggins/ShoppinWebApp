package com.ashishhiggins.shoppinwebapp.service.Impl;

import com.ashishhiggins.shoppinwebapp.dto.CouponDto;
import com.ashishhiggins.shoppinwebapp.entity.Coupon;
import com.ashishhiggins.shoppinwebapp.repository.CouponRepository;
import com.ashishhiggins.shoppinwebapp.service.ICouponService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service@AllArgsConstructor
public class CouponServiceImpl implements ICouponService {

    private CouponRepository couponRepository;

    @Override
    public List<CouponDto> fetchAllCoupon() {

        List<Coupon> list = couponRepository.findAll();

        return list.stream().map(coupon -> {
            CouponDto couponDto = new CouponDto();
            couponDto.setCode(coupon.getCode());
            couponDto.setDiscount(coupon.getDiscount());
            return couponDto;
        }).toList();

    }

    @Override
    public boolean validateCoupon(String couponCode) {

        Optional<Coupon> coupon = (couponRepository.findByCode(couponCode));

        if (coupon.isPresent())
            return true;

        return false;
    }
}
