package com.bootcamp.casadocodigo.validations;

import com.bootcamp.casadocodigo.purchase.NewPurchaseRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ValidatedCPFAndCNPJ implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return NewPurchaseRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NewPurchaseRequest request = (NewPurchaseRequest) o;
        if (!request.validDocument()) {
            errors.rejectValue("documento", null, "documento precisa ter formato de um cpf ou cnpj");
        }
    }
}
