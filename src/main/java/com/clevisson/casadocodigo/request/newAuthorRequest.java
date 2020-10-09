package com.clevisson.casadocodigo.request;

import com.clevisson.casadocodigo.model.Author;
import com.clevisson.casadocodigo.genericvalidation.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class newAuthorRequest {
    @NotBlank(message = "{name.not.blank}")
    private final String name;
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    @UniqueValue(domainClass = Author.class, fieldName = "email")
    private final String email;
    @NotBlank
    @Size(max = 400)
    private final String description;

    public newAuthorRequest(@NotBlank String name,
                            @NotBlank @Email  String email,
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
