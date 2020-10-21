package com.bootcamp.casadocodigo.purchase;

import com.bootcamp.casadocodigo.coupon.CouponRepository;
import com.bootcamp.casadocodigo.validations.StateBelongsToCountry;
import com.bootcamp.casadocodigo.validations.ValidCoupon;
import com.bootcamp.casadocodigo.validations.ValidatedCPFAndCNPJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/purchase")
public class PurchaseController {
    @PersistenceContext
    EntityManager manager;
    @Autowired
    CouponRepository couponRepository;
    @Autowired
    StateBelongsToCountry stateBelongsToCountry;
    @Autowired
    ValidCoupon validCoupon;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new ValidatedCPFAndCNPJ(), stateBelongsToCountry, validCoupon);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Purchase> createPurchase(@RequestBody @Valid NewPurchaseRequest request) {
        Purchase purchase = request.toModel(manager, couponRepository);
        manager.persist(purchase);
        return ResponseEntity.status(201).build();
    }
}
