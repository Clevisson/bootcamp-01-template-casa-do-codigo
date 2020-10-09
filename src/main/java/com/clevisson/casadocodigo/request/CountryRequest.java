package com.clevisson.casadocodigo.request;

import com.clevisson.casadocodigo.genericvalidation.UniqueValue;
import com.clevisson.casadocodigo.model.Country;

import javax.validation.constraints.NotNull;

public class CountryRequest {
    @UniqueValue(domainClass = Country.class, fieldName = "name")
    @NotNull
    String name;

    public CountryRequest(@NotNull String name) {
        this.name = name;
    }
}
