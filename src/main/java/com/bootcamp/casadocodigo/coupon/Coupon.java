package com.bootcamp.casadocodigo.coupon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String code;
    @NotNull
    @Positive
    private BigDecimal discountPercentage;
    @Future
    @NotNull
    private LocalDate validity;

    @Deprecated
    public Coupon() {

    }

    public Coupon(@NotBlank String code, @NotNull @Positive BigDecimal discountPercentage, @Future @NotNull LocalDate validity) {
        this.code = code;
        this.discountPercentage = discountPercentage;
        this.validity = validity;
    }

    public void update(NewCouponRequest request) {
        this.code = request.getCode();
        this.discountPercentage = request.getDiscountPercentage();
        this.validity = request.getValidity();
    }

    public Boolean valid() {
        return LocalDate.now().compareTo(this.validity) <= 0;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public String getCode() {
        return code;
    }

}
