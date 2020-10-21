package com.bootcamp.casadocodigo.validations;

import com.bootcamp.casadocodigo.coupon.Coupon;
import com.bootcamp.casadocodigo.coupon.CouponRepository;
import com.bootcamp.casadocodigo.purchase.NewPurchaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidCoupon implements Validator {
    @Autowired
    private CouponRepository couponRepository;


    @Override
    public boolean supports(Class<?> clazz) {
        return NewPurchaseRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NewPurchaseRequest request = (NewPurchaseRequest) target;
        Optional<String> possibleCode = request.getCouponCode();
        if (possibleCode.isPresent()) {
            Coupon coupon = couponRepository.getByCode(possibleCode.get());
            if (!coupon.valid()) {
                errors.rejectValue("codigoCupom", null, "Este cupom não é válido");
            }
        }
    }
}
