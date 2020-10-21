package com.bootcamp.casadocodigo.country;

import com.bootcamp.casadocodigo.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NewCountryRequest {
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
