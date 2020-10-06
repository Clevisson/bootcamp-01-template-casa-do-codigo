package com.clevisson.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;

@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode ser vazio")
    private String name;

    public Category(@NotBlank(message = "O nome não pode ser vazio") String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Categoria [id:" + id + ",nome:" + name + "]";
    }
}
