package com.Assignment.Ecommerce.Service;

import com.Assignment.Ecommerce.Model.Cart;
import com.Assignment.Ecommerce.Model.Coupon;
import com.Assignment.Ecommerce.Repository.CouponRepository;
import com.Assignment.Ecommerce.domains.BxGyDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

        final ObjectMapper objectMapper=new ObjectMapper();

        BxGyDetails details=objectMapper.convertValue(updatedCoupon.getDetails(), BxGyDetails.class);
        System.out.println(details.getGetProducts().size());

        if(findCoupon.isPresent()){
            findCoupon.get().setDetails(updatedCoupon.getDetails());
            findCoupon.get().setType(updatedCoupon.getType());
            couponRepository.save(findCoupon.get());
        }
       return couponRepository.findById(id).get();


    }

    public String deleteCoupon(String id){
        couponRepository.deleteById(id);
        return "Coupon deleted successfully";
    }

    public List<Coupon>getApplicableCoupons(Cart cart){
        List<Coupon>coupons=couponRepository.findAll();
        List<Coupon>activeCoupons=coupons.stream()
                .filter(coupon -> coupon.getExpiryDate()
                        .isAfter(LocalDate.now())).toList();

       return List.of();

    }
}
