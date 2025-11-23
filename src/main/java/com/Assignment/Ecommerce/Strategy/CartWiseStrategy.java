package com.Assignment.Ecommerce.Strategy;

import com.Assignment.Ecommerce.DTO.CartDTO;
import com.Assignment.Ecommerce.Model.Coupon;
import com.Assignment.Ecommerce.domains.CartwiseDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class CartWiseStrategy implements CouponStrategy{
private final ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public boolean isApplicable(Coupon coupon, CartDTO cart) {
        CartwiseDetails details=objectMapper.convertValue(
                coupon.getDetails(),
                CartwiseDetails.class
        );
        Double cartTotal=cart.calculateTotal();
        return cartTotal>=details.getThreshold();

    }

    @Override
    public Double calculateDiscount(Coupon coupon, CartDTO cart) {
        if(!isApplicable(coupon,cart)){
            return 0.0;
        }
        CartwiseDetails details=objectMapper.convertValue(
                coupon.getDetails(), CartwiseDetails.class
        );
        Double cartTotal=cart.calculateTotal();
        Double discount=(cartTotal- details.getDiscount())/100;
        return discount;
    }

    @Override
    public CartDTO applyDiscount(Coupon coupon, CartDTO cart) {
        Double totalDiscount=calculateDiscount(coupon, cart);

        Double cartTotal=cart.calculateTotal();

        cart.getItems().forEach(item->{
            Double itemTotal=item.getPrice()*item.getQuantity();
            Double itemDiscount=(itemTotal/cartTotal)*totalDiscount;
            item.setTotalDiscount(itemDiscount);
        });
        return cart;
    }
}
