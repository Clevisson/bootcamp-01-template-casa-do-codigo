package com.clevisson.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    String name;

    @ManyToOne
    @NotNull
    Country country;

    public State(@NotBlank String name, @NotNull Country country) {
        this.name = name;
        this.country = country;
    }


}
