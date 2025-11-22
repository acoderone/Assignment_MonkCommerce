package com.Assignment.Ecommerce.Model;

import com.Assignment.Ecommerce.enums.COUPON_TYPES;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document("coupons")
public class Coupon {

    @Id
    private String id;
    private COUPON_TYPES type;
    private Map<String,Object> details;
    private Map<String,Object>conditions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public COUPON_TYPES getType() {
        return type;
    }

    public void setType(COUPON_TYPES type) {
        this.type = type;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }


}
