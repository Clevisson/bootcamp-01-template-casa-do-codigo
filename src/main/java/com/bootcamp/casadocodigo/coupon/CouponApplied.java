package com.bootcamp.casadocodigo.coupon;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public class CouponApplied {
    @ManyToOne
    private Coupon coupon;
    @Positive
    @NotNull
    private BigDecimal discountPercentage;
    @NotNull
    @Future
    private LocalDate momentValidity;

    @Deprecated
    public CouponApplied() {
    }

    public CouponApplied(Coupon coupon) {
        this.coupon = coupon;
        this.discountPercentage = coupon.getDiscountPercentage();
        this.momentValidity = coupon.getValidity();
    }
}
