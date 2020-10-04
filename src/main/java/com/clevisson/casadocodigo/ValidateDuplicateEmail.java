package com.clevisson.casadocodigo;

import com.clevisson.casadocodigo.model.Author;
import com.clevisson.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
@Component
public class ValidateDuplicateEmail implements Validator {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return newAuthorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        newAuthorRequest request = (newAuthorRequest) target;

        Optional<Author> possibleAuthor = authorRepository
                .findByEmail(request.getEmail());

        if (possibleAuthor.isPresent()) {
            errors.rejectValue("email", null,
                    "Já existe um(a) outro(a) autor(a) com o mesmo email "
                            + request.getEmail());
        }
    }
}
