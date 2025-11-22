package com.Assignment.Ecommerce.Service;

import com.Assignment.Ecommerce.Model.Coupon;
import com.Assignment.Ecommerce.Repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;
    public Coupon addCoupon(Coupon coupon){
        couponRepository.save(coupon);
        System.out.println(coupon.getId());
        return coupon;
    }

    public List<Coupon> getCoupons(){
        return couponRepository.findAll();
    }

    public Coupon getCouponById(String id){
        Optional<Coupon> findCoupon=couponRepository.findById(id);

        return findCoupon.get();
    }

    public Coupon updateCouponDetails(String id,Coupon updatedCoupon){
        Optional<Coupon>findCoupon=couponRepository.findById(id);
        if(findCoupon.isPresent()){
            findCoupon.get().setDetails(updatedCoupon.getDetails());
            findCoupon.get().setType(updatedCoupon.getType());
            couponRepository.save(findCoupon.get());
        }
       return couponRepository.findById(id).get();


    }

}
