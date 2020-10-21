package com.bootcamp.casadocodigo.category;

import com.bootcamp.casadocodigo.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NewCategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


