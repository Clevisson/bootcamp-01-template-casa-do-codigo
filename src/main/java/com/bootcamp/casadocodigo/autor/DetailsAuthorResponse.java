package com.bootcamp.casadocodigo.autor;

public class DetailsAuthorResponse {

    private final String name;
    private final String description;

    public DetailsAuthorResponse(Author author) {
        name = author.getName();
        description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
