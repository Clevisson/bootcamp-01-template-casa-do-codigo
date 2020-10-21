package com.bootcamp.casadocodigo.coupon;

import org.springframework.data.repository.CrudRepository;

public interface CouponRepository extends CrudRepository<Coupon, Long> {
    Coupon getByCode(String couponCode);
}
