package com.clevisson.casadocodigo.request;

import com.clevisson.casadocodigo.genericvalidation.UniqueId;
import com.clevisson.casadocodigo.genericvalidation.UniqueValue;
import com.clevisson.casadocodigo.model.Country;
import com.clevisson.casadocodigo.model.State;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

public class newStateRequest {
    @UniqueValue(domainClass = State.class, fieldName = "name")
    @NotNull
    private String name;
    @UniqueId(domainClass = Country.class, fieldName = "id")
    long idCountry;

    public newStateRequest(@NotNull String name, Long idCountry){
        this.name = name;
        this.idCountry = idCountry;
    }

    public State toModel(EntityManager manager){
        return new State(name, manager.find(Country.class, idCountry));
    }
}
