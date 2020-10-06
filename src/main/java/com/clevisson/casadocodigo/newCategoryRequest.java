package com.clevisson.casadocodigo;

import javax.validation.constraints.NotBlank;

public class newCategoryRequest {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


