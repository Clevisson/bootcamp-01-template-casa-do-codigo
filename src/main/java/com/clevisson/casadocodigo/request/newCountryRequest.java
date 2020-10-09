package com.clevisson.casadocodigo.request;

import com.clevisson.casadocodigo.genericvalidation.UniqueValue;
import com.clevisson.casadocodigo.model.Country;

import javax.validation.constraints.NotBlank;

public class newCountryRequest {
    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name")
    String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
