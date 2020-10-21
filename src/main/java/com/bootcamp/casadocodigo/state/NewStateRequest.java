package com.bootcamp.casadocodigo.state;

import com.bootcamp.casadocodigo.country.Country;
import com.bootcamp.casadocodigo.validations.UniqueId;
import com.bootcamp.casadocodigo.validations.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

public class NewStateRequest {
    @UniqueValue(domainClass = State.class, fieldName = "name")
    @NotNull
    private final String name;
    @UniqueId(domainClass = Country.class, fieldName = "id")
    private final long idCountry;

    public NewStateRequest(@NotNull String name, Long idCountry) {
        this.name = name;
        this.idCountry = idCountry;
    }

    public State toModel(EntityManager manager) {
        return new State(name, manager.find(Country.class, idCountry));
    }
}
