package com.bootcamp.casadocodigo.country;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/country")
public class CountryController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Country> createCountry(@RequestBody @Valid NewCountryRequest request) {
        Country country = new Country(request.getName());
        manager.persist(country);
        return ResponseEntity.status(201).build();
    }
}
