package com.bootcamp.casadocodigo.book;

import com.bootcamp.casadocodigo.autor.Author;
import com.bootcamp.casadocodigo.category.Category;
import com.bootcamp.casadocodigo.validations.UniqueId;
import com.bootcamp.casadocodigo.validations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NewBookRequest {
    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private final String title;
    @NotBlank
    @Size(max = 500)
    private final String resume;
    @NotBlank
    private final String summary;
    @Min(20)
    private final BigDecimal price;
    @Min(100)
    private final int numberPages;
    @NotBlank
    private final String isbn;
    @NotNull
    @Future
    @JsonProperty("publicationDate")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;
    @NotNull
    @UniqueId(domainClass = Category.class, fieldName = "id")
    private final Long idCategory;
    @NotNull
    @UniqueId(domainClass = Author.class, fieldName = "id")
    private final Long idAuthor;

    public NewBookRequest(@NotBlank String title,
                          @NotBlank @Size(max = 500) String resume,
                          @NotBlank String summary,
                          @Min(20) BigDecimal price,
                          @Min(100) int numberPages,
                          @NotBlank String isbn,
                          @NotNull LocalDate publicationDate,
                          @NotNull Long idCategory,
                          @NotNull Long idAuthor) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.idCategory = idCategory;
        this.idAuthor = idAuthor;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Book toModel(EntityManager manager) {
        @NotNull Author author = manager.find(Author.class, idAuthor);
        @NotNull Category category = manager.find(Category.class, idCategory);
        Assert.state(author != null, "O autor informado não existe no banco de dados" + idAuthor);
        Assert.state(category != null, "A categoria informada não existe no banco de dados" + idCategory);
        return new Book(title, resume, summary, price, numberPages, isbn, publicationDate, category, author);
    }
}
