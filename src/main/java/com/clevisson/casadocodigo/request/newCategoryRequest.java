package com.clevisson.casadocodigo.request;

import com.clevisson.casadocodigo.model.Category;
import com.clevisson.casadocodigo.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class newCategoryRequest {

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


