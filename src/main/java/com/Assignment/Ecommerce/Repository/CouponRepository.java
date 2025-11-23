package com.Assignment.Ecommerce.Repository;

import com.Assignment.Ecommerce.Model.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends MongoRepository<Coupon,Long> {
    Optional<Coupon> findById(String id);
    void deleteById(String id);
}
