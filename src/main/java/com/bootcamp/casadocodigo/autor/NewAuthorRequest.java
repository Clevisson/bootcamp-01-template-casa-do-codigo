package com.bootcamp.casadocodigo.autor;

import com.bootcamp.casadocodigo.validations.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewAuthorRequest {
    @NotBlank
    private final String name;
    @NotBlank
    @Email
    @UniqueValue(domainClass = Author.class, fieldName = "email")
    private final String email;
    @NotBlank
    @Size(max = 400)
    private final String description;

    public NewAuthorRequest(@NotBlank String name,
                            @NotBlank @Email String email,
                            @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author toModel() {
        return new Author(this.name, this.email, this.description);
    }

    public String getEmail() {
        return this.email;
    }
}
