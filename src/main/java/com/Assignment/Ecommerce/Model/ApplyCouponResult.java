package com.Assignment.Ecommerce.Model;

import java.util.List;

public class ApplyCouponResult {

    private UpdatedCart updatedCart;

    public static class UpdatedCart {
        private List<CartItemResult> items;
        private double totalPrice;
        private double totalDiscount;
        private double finalPrice;
    }

    public static class CartItemResult {
        private Long productId;
        private int quantity;
        private double price;
        private double totalDiscount;
    }
}
