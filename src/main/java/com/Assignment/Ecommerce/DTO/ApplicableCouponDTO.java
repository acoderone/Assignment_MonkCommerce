package com.Assignment.Ecommerce.DTO;


import com.Assignment.Ecommerce.enums.COUPON_TYPES;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicableCouponDTO {
    private String couponId;
    private String code;
    private COUPON_TYPES type;
    private Double discount;
}

