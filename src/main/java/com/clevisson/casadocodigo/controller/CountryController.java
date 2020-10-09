package com.clevisson.casadocodigo.controller;

import com.clevisson.casadocodigo.model.Country;
import com.clevisson.casadocodigo.request.newCountryRequest;
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
    public String createCountry(@RequestBody @Valid newCountryRequest request){
        Country country = new Country(request.getName());
        manager.persist(country);
        return "Salvei no banco";
    }
}
