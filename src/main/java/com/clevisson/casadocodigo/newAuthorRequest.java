package com.clevisson.casadocodigo;

import com.clevisson.casadocodigo.model.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class newAuthorRequest {
    @NotBlank
    private final String name;
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    @Size(max = 400)
    private final String description;

    public newAuthorRequest(@NotBlank String name,
                            @NotBlank @Email String email,
                            @NotBlank @Size(max = 400) String description) {
        super();
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
