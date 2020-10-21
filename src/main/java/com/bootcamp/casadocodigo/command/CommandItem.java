package com.bootcamp.casadocodigo.command;

import com.bootcamp.casadocodigo.book.Book;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Embeddable
public class CommandItem {
    private int amount;
    @ManyToOne
    private @NotNull Book book;
    @Positive
    private BigDecimal price;

    @Deprecated
    public CommandItem() {
    }

    public CommandItem(int amount, @NotNull Book book) {
        this.amount = amount;
        this.book = book;
        this.price = book.getPrice();
    }

    public BigDecimal total() {
        return price.multiply(new BigDecimal(amount));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((book == null) ? 0 : book.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CommandItem other = (CommandItem) obj;
        if (book == null) {
            if (other.book != null)
                return false;
        } else if (!book.equals(other.book))
            return false;
        return true;
    }
}
