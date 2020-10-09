package com.clevisson.casadocodigo.model;

import com.clevisson.casadocodigo.genericvalidation.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    @Deprecated
    public Category() {
    }


    public Category(@NotBlank String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Categoria [id:" + id + ",nome:" + name + "]";
    }
}
