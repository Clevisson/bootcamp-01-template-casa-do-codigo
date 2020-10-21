package com.bootcamp.casadocodigo.state;

import com.bootcamp.casadocodigo.country.Country;

import javax.persistence.*;
import javax.validation.Valid;
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
    @Valid
    Country country;

    @Deprecated
    public State() {

    }

    public State(@NotBlank String name, @NotNull @Valid Country country) {
        this.name = name;
        this.country = country;
    }

    public boolean belongsCountry(Country country) {
        return this.country.equals(country);
    }

}
