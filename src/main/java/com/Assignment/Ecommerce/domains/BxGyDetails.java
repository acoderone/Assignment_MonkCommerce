package com.Assignment.Ecommerce.domains;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BxGyDetails {
    @JsonProperty("buy_products")
    private List<BuyProduct> buyProducts;
    @JsonProperty("get_products")
    private List<GetProduct>getProducts;
    @JsonProperty("repition_limit")
    private int repetitionLimit;

    public static class BuyProduct{
        @JsonProperty("product_id")
        private Long productId;
        @JsonProperty("quantity")
        private int quantity;
    }

    public static class GetProduct{
        @JsonProperty("product_id")
        private Long productId;
        @JsonProperty("quantity")
        private int quantity;
    }

    public List<BuyProduct> getBuyProducts() {
        return buyProducts;
    }

    public void setBuyProducts(List<BuyProduct> buyProducts) {
        this.buyProducts = buyProducts;
    }

    public List<GetProduct> getGetProducts() {
        return getProducts;
    }

    public void setGetProducts(List<GetProduct> getProducts) {
        this.getProducts = getProducts;
    }

    public int getRepetitionLimit() {
        return repetitionLimit;
    }

    public void setRepetitionLimit(int repetitionLimit) {
        this.repetitionLimit = repetitionLimit;
    }
}
