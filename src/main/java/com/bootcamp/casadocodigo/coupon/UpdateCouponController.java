package com.bootcamp.casadocodigo.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class UpdateCouponController {
    @Autowired
    private CouponRepository repository;

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCouponbyId(@PathVariable("id") long id, @RequestBody NewCouponRequest coupon) {
        return repository.findById(id)
                .map(recordy -> {
                    recordy.update(coupon);
                    Coupon updated = repository.save(recordy);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
