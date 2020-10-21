package com.bootcamp.casadocodigo.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponRepository repository;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Coupon> CreateCoupon(@RequestBody @Valid NewCouponRequest request) {
        Coupon coupon = request.toModel();
        manager.persist(coupon);
        return ResponseEntity.status(201).build();
    }
}
