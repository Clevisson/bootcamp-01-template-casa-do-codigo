package com.bootcamp.casadocodigo.coupon;

import com.bootcamp.casadocodigo.validations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NewCouponRequest {
    @UniqueValue(domainClass = Coupon.class, fieldName = "code")
    @NotBlank
    private final String code;

    @Positive
    @NotNull
    private final BigDecimal discountPercentage;

    @Future
    @NotNull
    @JsonProperty("validity")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validity;

    public NewCouponRequest(@NotBlank String code, @Positive @NotNull BigDecimal discountPercentage, LocalDate validity) {
        this.code = code;
        this.discountPercentage = discountPercentage;
        this.validity = validity;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public Coupon toModel() {
        return new Coupon(code, discountPercentage, validity);
    }

}
