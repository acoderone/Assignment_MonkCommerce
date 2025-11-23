package com.Assignment.Ecommerce.DTO;


import com.Assignment.Ecommerce.enums.COUPON_TYPES;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicableCouponResponse {
    private List<ApplicableCouponDTO> applicableCoupons;
}
