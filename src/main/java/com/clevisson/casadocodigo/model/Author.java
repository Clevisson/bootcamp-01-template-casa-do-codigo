package com.clevisson.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode ser vazio")
    private String name;
    @NotBlank(message = "O email não pode ser vazio")
    @Email
    private String email;
    @NotBlank(message = "A descrição não pode ser vazia")
    @Size(max = 400, message = "A descrição não pode conter mais de 400 caracteres")
    private String description;
    //@NotNull(message = "O instate da criação não pode nula")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Deprecated
    public Author() {
    }

    public Author(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Autor [id=" + id + ", nome=" + name + ", email=" + email
                + ", descricao =" + description + ", criandoEm="
                + createdAt + "]";
    }
}
