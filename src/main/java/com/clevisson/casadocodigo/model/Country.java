package com.clevisson.casadocodigo.model;

import com.clevisson.casadocodigo.genericvalidation.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull
    String name;

    @Deprecated
    public Country(){
    }

    public Country(@NotBlank String name){
        this.name = name;
    }

}
