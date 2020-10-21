package com.bootcamp.casadocodigo.validations;

import com.bootcamp.casadocodigo.country.Country;
import com.bootcamp.casadocodigo.purchase.NewPurchaseRequest;
import com.bootcamp.casadocodigo.state.State;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class StateBelongsToCountry implements Validator {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NewPurchaseRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NewPurchaseRequest request = (NewPurchaseRequest) target;

        if (request.hasState()) {
            Country country = manager.find(Country.class, request.getIdCountry());
            State state = manager.find(State.class, request.getIdState());
            if (!state.belongsCountry(country)) {
                errors.rejectValue("idEstado", null, "este estado não pertence ao país selecionado");
            }
        }
    }
}
