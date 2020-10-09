package com.clevisson.casadocodigo.request;

import com.clevisson.casadocodigo.model.Author;

public class DetailsAuthorResponse {

    private String name;
    private String description;

    public DetailsAuthorResponse(Author author) {
        name = author.getName();
        description = author.getDescription();
    }
}
