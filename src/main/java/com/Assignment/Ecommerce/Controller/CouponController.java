package com.Assignment.Ecommerce.Controller;

import com.Assignment.Ecommerce.Model.Coupon;
import com.Assignment.Ecommerce.Service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class CouponController {
    @Autowired
    private CouponService couponService;
    @PostMapping("/add")
    public ResponseEntity<Coupon>addCouponController(@RequestBody Coupon coupon){
        return  ResponseEntity.ok().body(couponService.addCoupon(coupon));
    }

    @GetMapping("/coupons")
    public ResponseEntity<List<Coupon>>getCoupons(){
        return ResponseEntity.ok().body(couponService.getCoupons());
    }

    @GetMapping("/coupons/${id}")
    public ResponseEntity<Coupon>getCouponById(@PathVariable String id){
        return ResponseEntity.ok().body(couponService.getCouponById(id));
    }

    @PutMapping("/coupons/${id}")
    public ResponseEntity<Coupon>updateCouponById(@PathVariable String id,@RequestBody Coupon coupon){
        return ResponseEntity.ok().body(couponService.updateCouponDetails(id,coupon));
    }

}
