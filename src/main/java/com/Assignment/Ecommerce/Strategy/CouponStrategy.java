package com.Assignment.Ecommerce.Strategy;

import com.Assignment.Ecommerce.DTO.CartDTO;
import com.Assignment.Ecommerce.Model.Coupon;

public interface CouponStrategy {
boolean isApplicable(Coupon coupon, CartDTO cart);
Double calculateDiscount(Coupon coupon, CartDTO cart);
CartDTO applyDiscount(Coupon coupon,CartDTO cart);
}

