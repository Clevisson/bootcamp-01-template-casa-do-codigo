package com.clevisson.casadocodigo.request;

import com.clevisson.casadocodigo.genericvalidation.UniqueId;
import com.clevisson.casadocodigo.genericvalidation.UniqueValue;
import com.clevisson.casadocodigo.model.Author;
import com.clevisson.casadocodigo.model.Book;
import com.clevisson.casadocodigo.model.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NewBookRequest {
    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;
    @NotBlank
    @Size(max = 500)
    private String resume;
    @NotBlank
    private String summary;
    @NotNull
    @Size(min = 20)
    private BigDecimal price;
    @NotBlank
    @Size(min = 100)
    private Long NumberPages;
    @NotBlank
    private String isbn;
    @NotNull
    @JsonProperty("publicationDate")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate publicationDate;
    @NotNull
    @UniqueId(domainClass = Category.class, fieldName = "id")
    private Long idCategory;
    @NotNull
    @UniqueId(domainClass = Author.class, fieldName = "id")
    private Long idAuthor;

    public NewBookRequest(@NotBlank String title,
                          @NotBlank @Size(max = 500) String resume,
                          @NotBlank String summary,
                          @NotNull @Size(min = 20) BigDecimal price,
                          @NotBlank @Size(min = 100) Long numberPages,
                          @NotBlank String isbn,
                          @NotNull LocalDate publicationDate,
                          @NotNull Long idCategory,
                          @NotNull Long idAuthor) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.NumberPages = numberPages;
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
        return new Book(title, resume, summary, price, NumberPages, isbn, publicationDate, category, author);
    }


}
